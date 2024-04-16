package ge.tbc.tbcitacademy.database.steps;

import ge.tbc.tbcitacademy.database.MSSQL.MSSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSteps {

    public static ResultSet selectAllFromRegistrationData() throws SQLException {
        Connection connection = null;


        try {
            connection = MSSQLConnection.connect();
            String registrationdata = "SELECT * FROM RegistrationData";
            ResultSet resultSet = connection.createStatement().executeQuery(registrationdata);
            return resultSet;


        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
