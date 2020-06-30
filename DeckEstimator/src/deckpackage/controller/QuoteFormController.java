package deckpackage.controller;

import java.awt.Button;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import deckpackage.modal.FormModal;
import deckpackage.modal.LaborModal;
import deckpackage.modal.PrintModal;
import deckpackage.model.Quote;
import deckpackage.row.TableRow;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    @FXML private Pane topMenuPane;

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
    }

    public Parent getScene() throws IOException {
        Parent quoteForm = FXMLLoader.load(getClass().getResource("../view/QuotoForm.fxml"));
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
        String name = "";
        if (textName.getText().length() > 0) {
            name = textName.getText();
        }

        String phone = "";
        if (textPhone.getText().length() > 0) {
            phone = textPhone.getText();
        }

        String email = "";
        if (textEmail.getText().length() > 0) {
            email = textEmail.getText();
        }

        String woodType = "";
        if (dropdownWoodType.getText().length() > 0) {
            woodType = dropdownWoodType.getText();
        }

        Double height = 0.0;
        if (textHeight.getText().length() > 0) {
            height = Double.parseDouble(textHeight.getText());
        }

        Double breadth = 0.0;
        if (textBreadth.getText().length() > 0) {
            breadth = Double.parseDouble(textBreadth.getText());
        }

        Double length = 0.0;
        if (textLength.getText().length() > 0) {
            length = Double.parseDouble(textLength.getText());
        }

        Double laborCost = 0.0;
        if (textFieldLaborCost.getText().length() > 0) {
            laborCost = Double.parseDouble(textFieldLaborCost.getText().substring(1));
        }
    	String matString = createMatString();
        Quote q = new Quote(
                name,
                phone,
                email,
                woodType,
                height,
                breadth,
                length,
                matString,
                laborCost
        );

        XMLEncoder encoder; // q has to be a bean class
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("quotes/" + q.getDate() + ".xml")));
            encoder.writeObject(q);
            encoder.close();
        } catch(FileNotFoundException fileNotFound) {
            System.err.println("Error writing to file");
        }
    }

    @FXML
    private void addLabor(ActionEvent event) {
    	LaborModal modal = new LaborModal();
    	HashMap<String, String> values = modal.display();
    	textFieldLaborCost.setText(values.get("laborCost"));
    }

    @FXML
    private void onSelected(ActionEvent event) {
        dropdownWoodType.setText(((MenuItem) event.getSource()).getText());
    }

    @FXML
    String createMatString() {
    	String matString = "";
    	for (int i = 0; i < materialMenu.getItems().size(); i++) {
    		TableRow tableRow = materialMenu.getItems().get(i);
    		matString = matString + tableRow.getMaterialName()
    		+ " " + tableRow.getMaterialUnit()
    		+ " " + tableRow.getMaterialPPU()
    		+ " " + tableRow.getMaterialQuantity()
    		+ ",";
    	}
    	return matString;
    }

    @FXML
	void PrintOption(ActionEvent event) {
    	String laborCost;
    	String matString = createMatString();
		try {
			if (textFieldLaborCost.getText().length() == 0) laborCost = "0";
			else laborCost = textFieldLaborCost.getText().substring(1);
			PrintModal modal = new PrintModal();
			modal.showReceipt(dropdownWoodType.getText(),
	                Double.parseDouble(textHeight.getText()),
	                Double.parseDouble(textBreadth.getText()),
	                Double.parseDouble(textLength.getText()),
	                matString,
	                Double.parseDouble(laborCost));
	    } catch(Exception e) {
	        System.out.println("Can't Load Receipt"); //change to popup
	    }
	}
}
