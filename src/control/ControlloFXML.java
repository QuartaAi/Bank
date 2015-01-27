/*
 * ControlloFXML: controlla l'applicazione con interfaccia GUI Java FX.
 */

package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Sandro
 */
public class ControlloFXML extends Application implements Initializable {

    @FXML private ComboBox cmbConto, cmbOperazione;
    @FXML private TextField txtImporto;
    @FXML private TextArea textArea;
    @FXML private Button btnEsci, btnEsegui;
    
    @FXML
    private void handleBtnEseguiAction(ActionEvent event) {
        textArea.setText("OK");
    }
    
    @FXML
    private void handleBtnEsciAction(ActionEvent event) {
        textArea.setText(" ... chiusura applicazione ... ");
    }
    public static void fxmain(String[] args) {
        launch( args );
    }
    
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/mainframefx.fxml"));
        } catch (IOException ex) {
            System.out.println("ERRORE nel caricamento del frame FXML");
            System.exit(-1);
        }
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Bank FXML GUI");
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
