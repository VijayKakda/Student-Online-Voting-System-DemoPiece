package election.login;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class indexController {

    @FXML
    private Button gotoadminloginPageButton;

    @FXML
    private Button gotoVoteButton;

    @FXML
    private Button exitButton;

    //to exit the window

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }


    //going to the admin login page

    public void gotoadminloginPageButtonOnAction(ActionEvent event)  {

        try{

            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root,520,400));
            registerStage.show();

        }catch (Exception e){

            e.printStackTrace();;
            e.getCause();

        }
    }

    public void gotoVoteButtonOnAction(ActionEvent event)  {

        try{

            Parent root = FXMLLoader.load(getClass().getResource("studentlogin.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root,520,400));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();;
            e.getCause();

        }
    }

}
