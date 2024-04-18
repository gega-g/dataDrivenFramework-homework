package ge.tbc.tbcitacademy.registrationDatabase.steps;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;
import ge.tbc.tbcitacademy.util.GeneratePhoneNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

public class InsertPhoneNumbers {
    GeneratePhoneNumber generatePhoneNumber = new GeneratePhoneNumber();
    public int insertPhoneNumbers() throws SQLException {
        int affectedRows = 0;
        String selectSQL = "SELECT id FROM RegistrationData";
        String insertSQL = "INSERT INTO Phones VALUES(?, ?)";

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement selectStatement = conn.prepareStatement(selectSQL);
             ResultSet resultSet = selectStatement.executeQuery();
             PreparedStatement insertStatement = conn.prepareStatement(insertSQL)) {

            for (int i=0; i<8; i++) {
                resultSet.next();
                int id = resultSet.getInt("id");
                String phoneNumber = generatePhoneNumber.generatePhoneNumber();

                insertStatement.setString(1, phoneNumber);
                insertStatement.setInt(2, id);
                insertStatement.executeUpdate();
                affectedRows++;
            }
            System.out.println(affectedRows+" numbers have been added to Phone table");
            return affectedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
