package ge.tbc.tbcitacademy.registrationDatabase.steps;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import ge.tbc.tbcitacademy.registrationDatabase.configuration.DBConfiguration;

import java.sql.*;

public class DatabaseSteps {

    public static Connection connect() throws SQLException {
        try {
            DriverManager.registerDriver(new SQLServerDriver());

            String jdbcUrl = DBConfiguration.getURL();
            String password = DBConfiguration.getPassword();
            String username = DBConfiguration.getUsername();

            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet selectAllFromRegistrationData() throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM RegistrationData");
            return resultSet;
        } catch (SQLException e) {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            throw new RuntimeException(e);
        }
    }
}