package deckpackage.modal;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import java.util.HashMap;
import javafx.geometry.Insets;

/**
 *
 * @author 19tpe
 */
public class AppointmentModal {
    private HashMap<String, String> values = new HashMap<String, String>();
    
    public HashMap<String, String> display() {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Material");
        window.setMinWidth(250);
        VBox layout = new VBox(10);

    
        FormRow customer = new FormRow("Customer: ");
        FormRow date = new FormRow("Date: ");
        FormRow purpose = new FormRow("Purpose: ");

        Button submit = new Button("Create");
        submit.setOnAction(e -> {
            values.put("customer", customer.getValue());
            values.put("date", date.getValue());
            values.put("purpose", purpose.getValue());
            
            window.close();
        });
        
        layout.getChildren().addAll(customer, date, purpose, submit);
        layout.setPadding(new Insets(10,10,10,10));
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return values;
    }
    
    class FormRow extends HBox {
        private Label name;
        private TextField textField;

        public FormRow(String text) {
            name = new Label(text);
            textField = new TextField();
            
            this.getChildren().addAll(name, textField);
        }
        
        public String getValue() {
                return textField.getText();
        }
    }
}


