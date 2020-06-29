/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckpackage.controller;

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
    @FXML
    private Button appointmentIndexLink;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public MainSceneController() {}
    
    @FXML
     private void showQuoteIndex() throws IOException {
        Scene scene = quoteIndexLink.getScene();
        Parent quoteIndex = FXMLLoader.load(getClass().getResource("../view/QuoteIndex.fxml"));
        scene.setRoot(quoteIndex);
    }
   
    
    @FXML
    private void showQuoteForm(ActionEvent event) throws IOException {
        Scene scene = quoteLink.getScene();
        Parent quoteForm = FXMLLoader.load(getClass().getResource("../view/QuotoForm.fxml"));
        scene.setRoot(quoteForm);
    }
    
    @FXML
    private void showAppointmentIndex(ActionEvent event) throws IOException {
        Scene scene = appointmentIndexLink.getScene();
        System.out.println("here");
        Parent apptIndex = FXMLLoader.load(getClass().getResource("../view/AppointmentIndex.fxml"));
        scene.setRoot(apptIndex);
    }
}
