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
    private MainSceneController root;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent quoteIndex = FXMLLoader.load(getClass().getResource("QuoteIndex.fxml")); 
        Scene scene = new Scene(quoteIndex, 900, 500);
        root = new MainSceneController();
        
        stage.setTitle("Deck Estimator");
        stage.setResizable(false);
        stage.setScene(scene); 
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
