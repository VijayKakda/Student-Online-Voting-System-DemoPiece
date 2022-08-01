package election.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginController {
    @FXML
     private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    //To display New login detected and checking for username and password emptiness.

    public void loginButtonOnAction(ActionEvent e){


        if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false){

           // loginMessageLabel.setText("New login detected. ");
            validateLogin();


        }else{
            loginMessageLabel.setText("Please enter username and password ");
        }

    }

    //For closing the gui.when clicked cancel Button.

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

    //checking for correct and logging with correct user credentials.
    public void validateLogin(){

        DBConnection connectNow = new DBConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM admin WHERE username = \"" + usernameTextField.getText() + "\" AND password = \"" + passwordPasswordField.getText() + "\";";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while ((queryResult.next())){

                if(queryResult.getInt(1) == 1){
                    //loginMessageLabel.setText("Welcome ! ");
                    createAccountForm();

                }
                else{
                    loginMessageLabel.setText("Invalid login. Please try again. ");
                }
            }

        } catch (Exception e){

            e.printStackTrace();

        }

    }

    //for user registration

    public void createAccountForm (){

        try{

            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
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















