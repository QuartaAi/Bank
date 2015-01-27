/*
 * ControlloTUI: classe per il controllo con interfaccia utente testuale.
 */

package control;

import model.*;
import view.*;

/**
 *
 * @author Sandro
 */
public class ControlloTUI {

    AccountList ccc = null;
    MainframeTUI frm = null;

    public ControlloTUI() {
        ccc = new AccountList();
        frm = new MainframeTUI();
    }

    public void test() {
        // estrae un conto a caso e vi effettua su delle operazioni demo
        java.util.Random rand = new java.util.Random();
        Account cc = ccc.getAccount(rand.nextInt(ccc.getLength()));
        cc.deposita(rand.nextInt(1000));
        cc.preleva( rand.nextInt(100));
        frm.show( cc.getEstrattoConto() );
        cc.saveToFile();
    }

}
