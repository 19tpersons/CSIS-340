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
 * @author Rachel
 */
public class LaborModal {
    private HashMap<String, String> values = new HashMap<String, String>();
    
    public HashMap<String, String> display() {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Calculate Labor.");
        window.setMinWidth(250);
        VBox layout = new VBox(10);

        FormRow workers = new FormRow("# of Workers:");
        FormRow hours = new FormRow("Hours worked:");
        FormRow pricePerHour = new FormRow("Price Per hour: ");
        
        
        Button submit = new Button("Create");
        submit.setOnAction(e -> {
            //values.put("numberWorkers", workers.getValue());
            //values.put("hours", hours.getValue());
            //values.put("pph", pricePerHour.getValue());
            values.put("laborCost", String.valueOf(Integer.parseInt(workers.getValue()) 
            		* Double.parseDouble(hours.getValue()) 
            		* Double.parseDouble(pricePerHour.getValue())));
            
            window.close();
        });
        
        layout.getChildren().addAll(workers, hours, pricePerHour, submit);
        
        
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


