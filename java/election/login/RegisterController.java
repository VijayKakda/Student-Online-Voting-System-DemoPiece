package election.login;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.Statement;


public class RegisterController {

    @FXML
    private Button closeButton;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private Button closeButtonLabel;

    @FXML
    private PasswordField setPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField usernameTextField;



    //when clicked register button it checks for password match and displaying registered successfully acc.to it.

    public void registrationButtonOnAction(ActionEvent event){

        if (setPasswordField.getText().equals(confirmPasswordField.getText())){

            confirmPasswordLabel.setText(" ");
            registerUser();

        } else {

            confirmPasswordLabel.setText("Password does not match. ");

        }


    }

    //close button exit

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();

    }


    //checking for confirm password match and displaying reg.successfully.

    public void registerUser(){
        DBConnection connection = new DBConnection();
        Connection connectDB = connection.getConnection();

        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String password = setPasswordField.getText();

        String insertFields = "INSERT INTO student(name,username,password) VALUES ('";
        String insertValues = name + "','" + username + "','" + password + "')" ;
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessageLabel.setText("User has been registered successfully !");


        } catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }


    }






}



