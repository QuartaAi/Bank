/*
 * AccountList.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sandro
 */
public class AccountList {

    ArrayList<Account> conti = null;

    public AccountList() {
        conti = new ArrayList<>();
        load();
    }

    public Account getAccount( int index ) {
        return conti.get(index);
    }

    public String getList() {
        String s = "";
        for (int i = 0; i < conti.size(); i++) {
            if (i>0) s+=",";
            s += conti.get(i).getCodice();
        }
        return s;
    }
    
    public int getLength() {
        return conti.size();
    }
    
    private int load() {
        String[] cc_list;
        File f = new File("data/CC_list.txt");
        conti.clear();
        try {
            Scanner lettore = new Scanner(f);
            String s = lettore.nextLine();
            cc_list = s.split(",");
        } catch (FileNotFoundException ex) {
            System.out.println("ERRORE CARICAMENTO DATI - File CC_index.txt non trovato - " + ex.getMessage());
            return 0;
        }
        for (String cc_codice : cc_list) {
            Account cc = new Account(cc_codice);
            conti.add(cc);
        }
        return conti.size();
    }
    
}
