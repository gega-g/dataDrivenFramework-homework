package ge.tbc.tbcitacademy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOneInRegistration {
    public void insert(Connection conn, UserRegistration registration) throws SQLException {
        String SQL = "INSERT INTO RegistrationData VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            setPreparedStatement(preparedStatement, registration);
            preparedStatement.executeUpdate();
        }
    }

    private void setPreparedStatement(PreparedStatement preparedStatement, UserRegistration registration) throws SQLException {
        preparedStatement.setInt(1, registration.id);
        preparedStatement.setString(2, registration.firstName);
        preparedStatement.setString(3, registration.lastName);
        preparedStatement.setString(4, registration.gender);
        preparedStatement.setString(5, registration.deviceModel);
        preparedStatement.setString(6, registration.address1);
        preparedStatement.setString(7, registration.address2);
        preparedStatement.setString(8, registration.city);
        preparedStatement.setString(9, registration.phoneNumber);
        preparedStatement.setString(10, registration.idNumber);
    }
}