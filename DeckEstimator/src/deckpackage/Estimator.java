package deckpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 19tpe
 */
public class Estimator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("QuotoForm.fxml"));
        Scene scene = new Scene(root, 900, 500);
        stage.setTitle("Deck Estimator");
        stage.setResizable(false);
        stage.setScene(scene); //when we are at the point where we need to change the page we are on, you will use this method.
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
