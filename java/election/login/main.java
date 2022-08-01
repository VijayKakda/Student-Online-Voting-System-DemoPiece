package election.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
       // primaryStage.setTitle("Hello!");
        primaryStage.setScene(new Scene(root,520,400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}