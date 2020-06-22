package deckpackage;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

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
    @FXML public TextField textFieldLaborCost;

    @FXML
    private Button LaborButton;
    @FXML
    private Button submitButton;
    @FXML
    private Pane topMenuPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {        
            Pane mainScene = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            topMenuPane.getChildren().add(mainScene);
        } catch (IOException ex) {
            Logger.getLogger(QuoteFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Parent getScene() throws IOException {
        Parent quoteForm = FXMLLoader.load(getClass().getResource("QuotoForm.fxml"));        
        return quoteForm;
    }
    
    
    @FXML
    private void addMaterial(ActionEvent event) {
        FormModal modal = new FormModal();
        HashMap<String, String> values = modal.display();
        
        ObservableList<TableRow> data = materialMenu.getItems();
        data.add(new TableRow(
                values.get("name"),
                values.get("unit"),
                values.get("pricePerUnit"),
                values.get("quantity")
        ));
    }

    @FXML
    private void submit(ActionEvent event) {
    	String matString = "";
    	for (int i = 0; i < materialMenu.getItems().size(); i++) {
    		TableRow tableRow = materialMenu.getItems().get(i);
    		matString = matString + tableRow.getMaterialName() 
    		+ " " + tableRow.getMaterialUnit() 
    		+ " " + tableRow.getMaterialPPU() 
    		+ " " + tableRow.getMaterialQuantity()
    		+ ",";
    	}

        Quote q = new Quote(
                textName.getText(),
                textPhone.getText(),
                textEmail.getText(),
                dropdownWoodType.getText(),
                Double.parseDouble(textHeight.getText()),
                Double.parseDouble(textBreadth.getText()),
                Double.parseDouble(textLength.getText()),
                matString,
                Double.parseDouble(textFieldLaborCost.getText().substring(1))
        );

        XMLEncoder encoder; // q has to be a bean class
        try{
            Date date = new Date();
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(String.valueOf(date.getTime()) + ".xml")));
            encoder.writeObject(q);
            encoder.close();
        }catch(FileNotFoundException fileNotFound){
            System.err.println("Error writing to file");
        }
    }

    @FXML
    private void addLabor (ActionEvent event) {
    	LaborModal modal = new LaborModal();
    	HashMap<String, String> values = modal.display();
    	textFieldLaborCost.setText(values.get("laborCost"));
    }
    
}
