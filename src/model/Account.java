/*
 * Account: gestione operazioni su un conto corrente serializzabile.
 */

package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sandro
 */
public class Account implements Serializable {

    private String codice;
    private double saldo;
    private ArrayList<String> movimenti;
    
    private static final SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
    private static final String errormsg = "Attenzione: Operazione non eseguita!";
    
    public static String codice2filename( String codice ) { 
        return "data/CC_" + codice + ".dat";
    }
    
    public Account(String codice) {
        File f = new File(Account.codice2filename(codice));
        if ( f.exists() ) {
            this.loadFromFile(codice);
        } else {
            this.codice = codice;
            this.saldo = 0.0;
            movimenti = new ArrayList<>();
            movimenti.add( dateformat.format(new Date()) + "\tApertura conto corrente '" + codice + "'" );
        }
    }
    
    public String preleva(double importo) {
        String log;
        if (importo > 0 && importo <= saldo) {
            saldo -= importo;
            log = dateformat.format(new Date()) + "\tPrelevati " + String.format("%-4.2f", importo) + " euro - [Saldo: " + String.format("%-4.2f", saldo) + "]";
            movimenti.add( log );
        } else log = errormsg;
        return log;
    }

    public String deposita(double importo) {
        String log;
        if (importo > 0) {
            saldo += importo;
            log = dateformat.format(new Date()) + "\tDepositati " + String.format("%-4.2f", importo) + " euro - [Saldo: " + String.format("%-4.2f", saldo) + "]";
            movimenti.add( log );
        } else log = errormsg;
        return log;
    }

    public String getCodice() {
        return codice;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getEstrattoConto() {
        String msg = "\nConto " + codice + " [Saldo: " + String.format("%-4.2f", saldo) + "]\n";
        msg = movimenti.stream().map((mov) -> (mov + "\n")).reduce(msg, String::concat);
        return msg;
    }

    public boolean saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(Account.codice2filename(codice));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    private Account loadFromFile(String codice) {
        Account account;
        try {
            FileInputStream fis = new FileInputStream(Account.codice2filename(codice));
            ObjectInputStream ois = new ObjectInputStream(fis);
            account = (Account) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
        this.codice = account.codice;
        this.movimenti = account.movimenti;
        this.saldo = account.saldo;
        return account;
    }
    
}
