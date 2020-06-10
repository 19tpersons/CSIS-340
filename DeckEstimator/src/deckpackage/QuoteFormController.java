package deckpackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.HashMap;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author 19tpe
 */
public class QuoteFormController implements Initializable {

    @FXML
    private TableView materialMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addMaterial(ActionEvent event) {
        FormModal modal = new FormModal();
        HashMap<String, String> values = modal.display();
        
        if (!values.isEmpty()) {
            MaterialRow row = new MaterialRow(values);
            //materialMenu.getItems().add(new TableRow("a", "b", "c", "d"));
        }
    }
    
    class MaterialRow extends HBox {
        public MaterialRow(HashMap<String, String> values) {
            Label name = new Label(values.get("name"));
            Label unit = new Label(values.get("unit"));
            Label pricePerUnit = new Label(values.get("pricePerUnit"));
            Label quantity = new Label(values.get("quantity"));
            
            this.getChildren().addAll(name, unit, pricePerUnit, quantity);
        }
    }
}
