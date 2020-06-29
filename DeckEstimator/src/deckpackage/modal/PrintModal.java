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
	private int numberOfForms = 8;
	
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
		FormRowDetailed subtotalWood = new FormRowDetailed("Subtotal", laborCost);
		FormRowDetailed labor = new FormRowDetailed("Labor", laborCost);
		layout.getChildren().addAll(wood, type, amountOfWood, subtotalWood, materials);
		double matTotCost = 0.0;
		if (matString != "") {
			String[] bigMatList = matString.split(",");
			for (int i = 0; i < bigMatList.length; i++) {
				String[] smallMatList = bigMatList[i].split(" ");
				String matName = smallMatList[0];
				double matCost = Double.parseDouble(smallMatList[2]) * Double.parseDouble(smallMatList[3]);
				FormRowDetailed matRow = new FormRowDetailed(matName, matCost);
				layout.getChildren().add(matRow);
				matTotCost += matCost;
				numberOfForms++;
			}
		}
		else {
			FormRowDetailed matRow = new FormRowDetailed("No materials added", 0);
			layout.getChildren().add(matRow);
			numberOfForms++;
		}
		FormRowDetailed subtotalMats = new FormRowDetailed("Subtotal", matTotCost);
		window.setMinHeight(35 * numberOfForms);
		layout.getChildren().addAll(subtotalMats, labor, close);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
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
			String costStr = "$" + String.format("%.2f", cost);
			int rowLength = 150 - text.length();
			System.out.println(rowLength);
			String ellipses = "";
			for (int i = 0; i < rowLength; i++) {
				ellipses += ".";
			}
			if (text != "Labor") itemName = new Label("    " + text + " " + ellipses + " " + costStr);
			else itemName = new Label(" " + text + " " + ellipses + " " + costStr);
			this.getChildren().addAll(itemName);
		}
	}
}