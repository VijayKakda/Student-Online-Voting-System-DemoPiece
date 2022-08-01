package election.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class radiovoteController {

    @FXML
    public Button submitButton;
    @FXML
    public ToggleGroup radiovotingtoggle;
    @FXML
    private Label usernameTextField;
    @FXML
    private Label voteRecordLabel;
    @FXML
    private Button exitButton;

    public RadioButton candidate1;
    public RadioButton candidate2;

    public void submitButtonOnAction(ActionEvent e) {

        //getting username from studentLoginController to here..

        String username=studentLoginController.shiftingControllerUsername;

        try {

            DBConnection connection = new DBConnection();
            Connection connectDB = connection.getConnection();

            studentLoginController obj=new studentLoginController();


            //obj.loginButtonOnAction(usernameTextField.getText());

            String sqlInsert="UPDATE student SET voting_to = (?) WHERE name = '"+username+"';" ;
            PreparedStatement psInsert = connectDB.prepareStatement(sqlInsert);
            psInsert.setString(1, (((RadioButton) radiovotingtoggle.getSelectedToggle()).getText()));
            psInsert.executeUpdate();




            //alerting you vote has been recorded.

            voteRecordLabel.setText("Your vote has been updated to the database successfully ! \n\t\t\t\tThankYou for your vote.");



        }
        catch (SQLException asd){

            asd.printStackTrace();
        }

    }

    public void exitButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        Platform.exit();

    }



}
