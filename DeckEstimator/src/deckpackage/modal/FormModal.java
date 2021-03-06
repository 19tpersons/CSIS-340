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
public class FormModal {
    private HashMap<String, String> values = new HashMap<String, String>();
    
    public HashMap<String, String> display() {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add a material.");
        window.setMinWidth(250);
        VBox layout = new VBox(10);

    
        FormRow name = new FormRow("Name: ");
        FormRow pricePerUnit = new FormRow("Price Per Unit: ");
        FormRow quantity = new FormRow("Quantity: ");
        FormRow unit = new FormRow("Sold as (e.g. box): ");

        Button submit = new Button("Create");
        submit.setOnAction(e -> {
            values.put("name", name.getValue());
            values.put("unit", unit.getValue());
            values.put("pricePerUnit", pricePerUnit.getValue());
            values.put("quantity", quantity.getValue());
            
            window.close();
        });
        
        layout.getChildren().addAll(name, pricePerUnit, quantity, unit, submit);
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


