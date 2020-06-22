/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckpackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author 19tpe
 */
public class MainSceneController implements Initializable {
    @FXML
    private Button quoteLink;
    @FXML
    private Button quoteIndexLink;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public MainSceneController() {}
    
    @FXML
     private void showQuoteIndex() throws IOException {
        Scene scene = quoteIndexLink.getScene();
        Parent quoteIndex = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        scene.setRoot(quoteIndex);
    }
   
    
    @FXML
    private void showQuoteForm(ActionEvent event) throws IOException {
        Scene scene = quoteLink.getScene();
        Parent quoteForm = FXMLLoader.load(getClass().getResource("QuotoForm.fxml"));        
        scene.setRoot(quoteForm);
    }
}
