package deckpackage;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.HashMap;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author 19tpe
 */
public class QuoteFormController implements Initializable {

    @FXML private TableView<TableRow> materialMenu;
    @FXML private TextField textName;
    @FXML private TextField textPhone;
    @FXML private TextField textEmail;
    @FXML private TextField textHeight;
    @FXML private TextField textBreadth;
    @FXML private TextField textLength;
    @FXML private MenuButton dropdownWoodType;

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
        
        //if (!values.isEmpty()) {
            ObservableList<TableRow> data = materialMenu.getItems();
            data.add(new TableRow(
                    values.get("name"),
                    values.get("unit"),
                    values.get("pricePerUnit"),
                    values.get("quantity")
            ));
        //}
    }

    @FXML
    private void submit(ActionEvent event) {
        Quote q = new Quote(
                textName.getText(),
                textPhone.getText(),
                textEmail.getText(),
                dropdownWoodType.getText(),
                Double.parseDouble(textHeight.getText()),
                Double.parseDouble(textBreadth.getText()),
                Double.parseDouble(textLength.getText())
        );

        XMLEncoder encoder; // q has to be a bean class
        try{
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(q.getName() + ".xml")));
            encoder.writeObject(q);
            encoder.close();
        }catch(FileNotFoundException fileNotFound){
            System.err.println("Error writing to file");
        }
    }

    @FXML
    private void addLabor(ActionEvent event) {
    	FormModal modal = new FormModal();
        HashMap<String, String> values = modal.display();
        
    }
}
