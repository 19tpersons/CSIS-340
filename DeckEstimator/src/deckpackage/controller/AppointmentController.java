/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckpackage.controller;

import deckpackage.model.Appointment;
import deckpackage.model.Quote;
import deckpackage.row.IndexRow;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author 19tpe
 */
public class AppointmentController implements Initializable {
    @FXML private Pane topMenuPane;
    @FXML private VBox apptPanel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {        
            Pane mainScene = FXMLLoader.load(getClass().getResource("../view/MainScene.fxml"));
            topMenuPane.getChildren().add(mainScene);
        } catch (IOException ex) {
            Logger.getLogger(QuoteFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        readAppointments();
    }


    public Parent getScene() throws IOException {
        Parent apptScene = FXMLLoader.load(getClass().getResource("../view/AppointmentIndex.fxml"));
        return apptScene;
    }
    
    public AppointmentController() {}
    
    public void readAppointments() {
        XMLDecoder decoder;
        Appointment appt;
        
        HashMap<String, ArrayList<Appointment>> appts = new HashMap<String, ArrayList<Appointment>>();
        ArrayList<String> apptKeys = new ArrayList<String>();

        try {
            File folder = new File("appointments/");
            File[] listOfFiles = folder.listFiles();

            if(listOfFiles.length > 0) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
                        appt = (Appointment) decoder.readObject();

                        //add to array and hashmap
                        if (!apptKeys.contains(appt.getDate())) {
                           apptKeys.add(appt.getDate()); 
                        }
                        
                        if (appts.containsKey(appt.getDate())) {
                            ArrayList<Appointment> tmp = appts.get(appt.getDate());
                            tmp.add(appt);
                        } else {
                            ArrayList<Appointment> tmp = new ArrayList<Appointment>();
                            tmp.add(appt);
                            appts.put(appt.getDate(), tmp);
                        }                        
                    }
                }
                
                for (int i = 0; i < apptKeys.size(); i++) {
                    String date = apptKeys.get(i);
                    ArrayList<Appointment> dayAppts = appts.get(date);
                    VBox container = new VBox(5);
                    container.getChildren().add(new Label(date));
                    
                    for (int j = 0; j < dayAppts.size(); j++) {
                        HBox row = new HBox(5);
                        Appointment tempAppt = dayAppts.get(j);
                        
                        Label customer = new Label(tempAppt.getCustomer());
                        Label tempDate = new Label(tempAppt.getDate());
                        Label purpose = new Label(tempAppt.getPurpose());
                        
                        row.getChildren().addAll(customer, tempDate, purpose);
                        container.getChildren().add(row);
                    }
                    
                    apptPanel.getChildren().add(container);
                }                
            } else {
                System.out.println("Nothing to read");
            }
        } catch(Exception e) {
            System.err.println("There was a problem reading the files.");
            e.printStackTrace();
        }
    }
}
