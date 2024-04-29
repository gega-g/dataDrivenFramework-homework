package ge.tbc.tbcitacademy.registrationDatabase.steps;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRegistrationsAndPhoneNumbers {
    public int update() {
        String updateRegistrationSQL = "update RegistrationData set address1 = ?, contact1 = ? where id = ?";
        String updatePhoneNumberSQL = "update Phones set phoneNumber = ? WHERE ownerId = ?";

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement updateRegistrationStmt = conn.prepareStatement(updateRegistrationSQL);
             PreparedStatement updatePhoneNumberStmt = conn.prepareStatement(updatePhoneNumberSQL)) {
            int affectedRows = 0;

            // Update registration 1
            updateRegistrationStmt.setString(1, "newAddress");
            updateRegistrationStmt.setString(2, "newContact");
            updateRegistrationStmt.setInt(3, 1002);
            updateRegistrationStmt.executeUpdate();
            affectedRows++;

            // Update registration 2
            updateRegistrationStmt.setString(1, "axalisaxli");
            updateRegistrationStmt.setString(2, "axalisakontakto");
            updateRegistrationStmt.setInt(3, 1003);
            updateRegistrationStmt.executeUpdate();
            affectedRows++;

            // Update phone number 1
            updatePhoneNumberStmt.setString(1, "5555555551");
            updatePhoneNumberStmt.setInt(2, 1004);
            updatePhoneNumberStmt.executeUpdate();
            affectedRows++;

            // Update phone number 2
            updatePhoneNumberStmt.setString(1, "591259283");
            updatePhoneNumberStmt.setInt(2, 1005);
            updatePhoneNumberStmt.executeUpdate();
            affectedRows++;


            System.out.println(affectedRows + " rows have been affected.");
            return affectedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}