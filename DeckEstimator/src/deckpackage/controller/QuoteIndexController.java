/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckpackage.controller;

import deckpackage.modal.AppointmentModal;
import java.beans.XMLDecoder;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import deckpackage.model.Quote;
import deckpackage.row.IndexRow;
import java.util.HashMap;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 19tpe
 */
public class QuoteIndexController implements Initializable {    

    @FXML private Pane topMenuPane;
    @FXML private TableView<IndexRow> quoteTableView;

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

        readQuotes();
    }

    public Parent getScene() throws IOException {
        Parent quoteForm = FXMLLoader.load(getClass().getResource("../view/QuotoForm.fxml"));
        return quoteForm;
    }

    public void readQuotes() {
        XMLDecoder decoder;
        Quote quote;

        ObservableList<IndexRow> data = quoteTableView.getItems();

        try {
            File folder = new File("quotes/");
            File[] listOfFiles = folder.listFiles();

            if(listOfFiles.length > 0) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
                        quote = (Quote) decoder.readObject();

                        data.add(new IndexRow(
                                quote.getName(),
                                quote.getReadableDate(),
                                quote.getStatus()
                        ));
                    }
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
