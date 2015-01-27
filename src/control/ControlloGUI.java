    /*
 * ControlloGUI: classe per il controllo con interfaccia GUI JFrame
 */
package control;

import model.*;
import view.*;

/**
 *
 * @author Sandro
 */
public class ControlloGUI {

    AccountList ccc = null;
    MainframeGUI frm = null;

    public ControlloGUI() {
        ccc = new AccountList();
        frm = new MainframeGUI();
        frm.initControl( this, ccc.getList() );
        frm.setVisible(true);
    }
    
    public String exec(int cc, int op, double imp) {
        Account account = ccc.getAccount( cc );
        String msg = null;
        // Saldo, Deposito, Prelievo, Estratto conto
        switch (op) {
            case 0: // Saldo
                msg = String.format("Saldo: %.2f", account.getSaldo());
                break;
            case 1: // Deposito
                account.deposita(imp);
                msg = String.format("Importo versato! Nuovo saldo: %.2f", account.getSaldo());
                break;
            case 2: // Prelievo
                account.preleva(imp);
                msg = String.format("Importo prelevato! Nuovo saldo: %.2f", account.getSaldo());
                break;
            case 3: // Estratto conto
                msg = account.getEstrattoConto();
        }
        account.saveToFile();
        return msg;
    }
    
}
