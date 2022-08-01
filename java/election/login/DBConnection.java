package election.login;
import java.sql.Connection;     //for sql database connection
import java.sql.DriverManager;

public class DBConnection {

    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "election";
        String databaseUser = "root";
        String databasePassword = "password";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return databaseLink;

    }

}
