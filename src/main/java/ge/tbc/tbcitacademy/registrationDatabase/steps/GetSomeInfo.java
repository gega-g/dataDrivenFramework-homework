package ge.tbc.tbcitacademy.registrationDatabase.steps;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSomeInfo {

    public void info() {
        String SQL = """
                        select RegistrationData.firstName, RegistrationData.lastName, Phones.phoneNumber
                        from RegistrationData
                        inner join Phones on RegistrationData.id = Phones.ownerId;
                """;

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");
                System.out.println("First Name: " + firstName + ", Last Name: " + lastName + ", Phone Number: " + phoneNumber);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}