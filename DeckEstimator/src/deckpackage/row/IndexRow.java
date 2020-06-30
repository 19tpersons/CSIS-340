package deckpackage.row;

import deckpackage.modal.AppointmentModal;
import deckpackage.model.Appointment;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import java.io.FileNotFoundException;


/**
 *
 * @author Ethan Johnson
 */
public class IndexRow {
    private final SimpleStringProperty quoteName   = new SimpleStringProperty("");
    private final SimpleStringProperty quoteDate   = new SimpleStringProperty("");
    private final SimpleStringProperty quoteStatus = new SimpleStringProperty("");
    private final Button apptButton = new Button();

    public IndexRow(String name, String date, String status) {
        setQuoteName(name);
        setQuoteDate(date);
        setQuoteStatus(status);
        setApptButton("Make Appt.");
        
        apptButton.setOnAction(e -> {
            AppointmentModal apptModal = new AppointmentModal();
            apptModal.setDate(date);
            apptModal.setCustomer(name);
            HashMap<String, String> values = apptModal.display();
            
            Appointment q = new Appointment(
                values.get("customer"),
                values.get("date"),
                values.get("purpose")
            );

            XMLEncoder encoder; // q has to be a bean class
            try {
                encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("appointments/" + q.getCreatedAt() + ".xml")));
                encoder.writeObject(q);
                encoder.close();
            } catch(FileNotFoundException fileNotFound) {
                System.err.println("Error writing to file");
            } 
        });
    }

    public void setQuoteName(String name) {
        this.quoteName.set(name);
    }

    public void setQuoteDate(String date) {
        this.quoteDate.set(date);
    }

    public void setQuoteStatus(String status) {
        this.quoteStatus.set(status);
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

    public String getQuoteStatus() {
        return this.quoteStatus.get();
    }
    
    public Button getApptButton() {
        return this.apptButton;
    }
}
