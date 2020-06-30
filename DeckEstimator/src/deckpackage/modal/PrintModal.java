package deckpackage.modal;



import javafx.geometry.Insets;
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
		layout.setPadding(new Insets(10, 10, 10, 10));
		close.setOnAction(e -> {
			window.close();
		});
		double woodPrice = 0.0;
		/*if (woodType.contains("Green")) woodPrice = 1.50;
		else if (woodType.contains("Brown")) woodPrice = 1.75;
		else if (woodType.contains("Maintenance")) woodPrice = 2.0;
		else if (woodType.contains("Custom")) woodPrice = 3.0;*/
		FormRowDetailed type = new FormRowDetailed(woodType, woodPrice);
		//double dimension = (length * breadth * height);
		FormRowDetailed amountOfWood = new FormRowDetailed(
				"Deck Size " + height + "ft. x" + breadth + "ft. x" + length + "ft.",
				woodPrice);
		//double woodTotCost = woodPrice * dimension;
		//FormRowDetailed subtotalWood = new FormRowDetailed("Subtotal", woodTotCost);
		FormRowDetailed labor = new FormRowDetailed("Labor", laborCost);
		layout.getChildren().addAll(wood, type, amountOfWood, /*subtotalWood,*/ materials);
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
		FormRowDetailed totalCost = new FormRowDetailed("Total", /*woodTotCost + */laborCost + matTotCost);
		layout.getChildren().addAll(subtotalMats, labor, totalCost, close);
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
			String ellipses = "";
			for (int i = 0; i < rowLength; i++) {
				ellipses += ".";
			}
			if (text != "Labor" && text != "Total" && !text.contains("Deck Size") && !text.contains("Tree") && !text.contains("Custom")
					&& !text.contains("No materials added"))
				itemName = new Label("    " + text + " " + ellipses + " " + costStr);
			else if (text == "Labor" || text == "Total")
				itemName = new Label(" " + text + " " + ellipses + " " + costStr);
			else itemName = new Label("    " + text);
			this.getChildren().addAll(itemName);
		}
	}
}