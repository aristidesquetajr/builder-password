/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder.password;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author kashiki
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private ListView<String> listPassword;
    @FXML private CheckBox checkUpper, checkAlgarismos, checkSimbolo;
    @FXML private TextField txtNumCaracteres;
    
    @FXML private void handleBtnGearAction(ActionEvent event) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        
        if(checkUpper.isSelected()) {
            str += str.toUpperCase();
        }
        if(checkAlgarismos.isSelected()) {
            str += "0123456789";
        }
        if(checkSimbolo.isSelected()) {
            str += "#/$!?-+=\"";
        }
        
        listPassword.setItems(getItems(str.toCharArray()));
    }
    
    private ObservableList<String> getItems(char[] texto) {
        ObservableList<String> task = FXCollections.observableArrayList();
        int countCaracteres = Integer.parseInt(txtNumCaracteres.getText());
        String pass = "";
        Random rand = new Random();
        
        for(int i = 1; i <= 9; i++) {
            pass = "";
            for(int caract=1; caract <= countCaracteres; caract++) {
                pass += texto[rand.nextInt(texto.length)];
            }
            
            task.add(pass);
        }
        
        return task;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
