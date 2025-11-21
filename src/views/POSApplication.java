package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;   // ✅ CORRECT

public class POSApplication extends Application {
    public void start(Stage stage) {
        stage.setScene(new Scene(new Label("Hello"), 300, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);   // VALID
    }
}
