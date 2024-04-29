package ge.tbc.tbcitacademy.registrationDatabase.steps;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttachPhoneNumbersToUsers {
    public ResultSet attach() {
        String SQL = """
                select * from RegistrationData
                inner join Phones on RegistrationData.id = Phones.ownerId;
                """;

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
