package deckpackage;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.util.HashMap;


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

        FormRow name = new FormRow("Name:");
        FormRow unit = new FormRow("Unit:");
        FormRow pricePerUnit = new FormRow("Price Per Unit: ");
        FormRow quantity = new FormRow("Quantity");
        
        Button submit = new Button("Create");
        submit.setOnAction(e -> {
            values.put("name", name.getValue());
            values.put("unit", unit.getValue());
            values.put("pricePerUnit", pricePerUnit.getValue());
            values.put("quantity", quantity.getValue());
            
            window.close();
        });
        
        layout.getChildren().addAll(name, unit, pricePerUnit, quantity, submit);
        
        
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
