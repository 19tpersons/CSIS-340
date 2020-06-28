package deckpackage.modal;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * @author Ronni
 *
 */

public class PrintModal {
	
	public void showReceipt() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Receipt");
		window.setMinWidth(250);
		window.setMinHeight(250);
		VBox layout = new VBox(10);
		FormRow customerInfo = new FormRow("Contact Information");
		FormRow woodType = new FormRow("Wood Type");
		Button close = new Button("Exit");
		close.setOnAction(e -> {
			window.close();
		});
		layout.getChildren().addAll(customerInfo, woodType, close);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	class FormRow extends HBox {
		private Label name;
		
		public FormRow(String text) {
			name = new Label(text);
			this.getChildren().addAll(name);
		}
	}
}