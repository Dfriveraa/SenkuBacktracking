package solitario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Solitario extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTablero.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Solitario");
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
