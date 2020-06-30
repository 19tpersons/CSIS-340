package deckpackage.row;

import deckpackage.modal.AppointmentModal;
import deckpackage.model.Appointment;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.swing.JComboBox;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.io.FileNotFoundException;


/**
 *
 * @author Ethan Johnson
 */
public class IndexRow {
	public final static String[] items = {"Pending","In Progress", "Cancelled"};
    private final SimpleStringProperty quoteName   = new SimpleStringProperty("");
    private final SimpleStringProperty quoteDate   = new SimpleStringProperty("");
    private final ChoiceBox<String> quoteStatus = new ChoiceBox<String>();
    
    private final Button apptButton = new Button();
  
    public IndexRow(String name, String date){
        setQuoteName(name);
        setQuoteDate(date);
        setQuoteStatus(items);
        
        setApptButton("Make Appt.");
        
        apptButton.setOnAction(e -> {
            AppointmentModal apptModal = new AppointmentModal();
            HashMap<String, String> values = apptModal.display();
            
            Appointment q = new Appointment(
                values.get("customer"),
                values.get("date"),
                values.get("purpose")
            );

            XMLEncoder encoder; // q has to be a bean class
            try {
                encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("appointments/" + q.getDate() + ".xml")));
                encoder.writeObject(q);
                encoder.close();
            } catch(FileNotFoundException fileNotFound) {
                System.err.println("Error writing to file");
            } 
        });
    }




	private void setQuoteStatus(String[] items2) {
		this.quoteStatus.getItems().addAll("Pending","In Progress", "Cancalled","Queue");
		
	}




	public void setQuoteName(String name) {
        this.quoteName.set(name);
    }

    public void setQuoteDate(String date) {
        this.quoteDate.set(date);
    }

 
    
    public void setApptButton(String name) {
        apptButton.setText(name);
    }

    public String getQuoteName() {
        return this.quoteName.get();
    }

    public String getQuoteDate() {
        return this.quoteDate.get();
    }

    public ChoiceBox<String> getQuoteStatus() {
        return quoteStatus;
    	
    }
    
    public Button getApptButton() {
        return this.apptButton;
    }
}