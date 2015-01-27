/*
 * Bank.
 */

package control;

import java.util.Scanner;

/**
 *
 * @author Sandro
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n = 0;
        
        System.out.println("Bank application\nScegli quale versione eseguire:");
        System.out.println("1) TUI\n2) GUI JFrame\n3) GUI JavaFX\n0) Esci");
        Scanner lettore = new Scanner(System.in);
        try { n = lettore.nextInt(); } catch (Exception ex) { System.out.print("!!! "); }
        
        switch (n) {
            case 1:
                ControlloTUI ctrltui = new ControlloTUI();
                ctrltui.test();
                break;
            case 2:
                ControlloGUI ctrlgui = new ControlloGUI();
                break;
            case 3:
                ControlloFXML.fxmain(args);
                break;
            case 0:
                break;
            default:
                System.out.println("Scelta non valida!");
        }

    }
    
}
