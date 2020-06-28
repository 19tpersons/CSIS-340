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
	private int numberOfForms = 7;
	
	public void showReceipt(String woodType,
			double height,
            double breadth,
            double length,
            String matString,
            double laborCost) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Receipt");
		window.setMinWidth(250);
		VBox layout = new VBox(10);
		FormRow materials = new FormRow("Extra Materials");
		FormRow wood = new FormRow("Wood");
		Button close = new Button("Exit");
		close.setOnAction(e -> {
			window.close();
		});
		FormRowDetailed type = new FormRowDetailed(woodType, laborCost);
		FormRowDetailed amountOfWood = new FormRowDetailed(
				"Dimensions " + height + "x" + breadth + "x" + length,
				laborCost);
		FormRowDetailed subtotal = new FormRowDetailed("Subtotal", laborCost);
		/**************************here***************************/
		FormRowDetailed labor = new FormRowDetailed("Labor", laborCost);
		layout.getChildren().addAll(wood, type, amountOfWood, subtotal, materials);
		if (matString != "") {
			String[] bigMatList = matString.split(",");
			for (int i = 0; i < bigMatList.length; i++) {
				String[] smallMatList = bigMatList[i].split(" ");
				String matName = smallMatList[0];
				double matCost = Double.parseDouble(smallMatList[2]) * Double.parseDouble(smallMatList[3]);
				FormRowDetailed matRow = new FormRowDetailed(matName, matCost);
				layout.getChildren().add(matRow);
				numberOfForms++;
			}
		}
		window.setMinHeight(35 * numberOfForms);
		layout.getChildren().addAll(labor, close);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	FormRowDetailed createMatRows() {
		FormRowDetailed row = new FormRowDetailed("material name", 7.0);
		return row;
	}
	
	class FormRow extends HBox {
		private Label name;
		
		public FormRow(String text) {
			name = new Label(" " + text);
			this.getChildren().add(name);
		}
	}
	
	class FormRowDetailed extends HBox {
		private Label itemName;
		
		public FormRowDetailed(String text, double cost) {
			if (text != "Labor") itemName = new Label("	" + text + " ..... " + cost);
			else itemName = new Label(" " + text + " ..... " + cost);
			this.getChildren().addAll(itemName);
		}
	}
}