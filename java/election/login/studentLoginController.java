package election.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;

public class studentLoginController {

    @FXML
    private Button closeButton;
    @FXML
    public Button loginButton;
    @FXML
    public Label loginMessageLabel;
    @FXML
    public TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public static String shiftingControllerUsername;

    //to quit gui or close gui

    public void closeButtonOnAction(ActionEvent e){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }


//    public void loginButtonOnAction(ActionEvent e){
//
//
//        if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false){
//
//             loginMessageLabel.setText("New login detected. ");
//            // validateLogin();
//
//        }else{
//            loginMessageLabel.setText("Please enter username and password ");
//        }
//
//    }


    public void loginButtonOnAction(ActionEvent actionEvent) throws SQLException {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sqlLoginCheck = "SELECT * FROM student WHERE (username,password) =(?, ?)";
        PreparedStatement psLoginCredentials = connection.prepareStatement(sqlLoginCheck);
        psLoginCredentials.setString(1, usernameTextField.getText());

        shiftingControllerUsername=usernameTextField.getText();

        psLoginCredentials.setString(2, passwordPasswordField.getText());
        ResultSet resultSet = psLoginCredentials.executeQuery();


        if (resultSet.isBeforeFirst()) try {

            Parent root2 = FXMLLoader.load(getClass().getResource("radiovote.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root2);
            stage.setTitle("Welcome");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }

        else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Login Credentials are incorrect");
            alert.show();
            System.out.println("Incorrect Credentials");


        }


    }



}



