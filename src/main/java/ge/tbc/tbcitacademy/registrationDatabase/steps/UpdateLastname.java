package ge.tbc.tbcitacademy.registrationDatabase.steps;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateLastname {
    public int update() {
        String updateLastnameSQL = "update RegistrationData set lastname = ? where id = ?";

        try (Connection conn = MSSQLConnection.connect();
             PreparedStatement updateRegistrationStmt = conn.prepareStatement(updateLastnameSQL)) {

            updateRegistrationStmt.setString(1, "axaligvari");
            updateRegistrationStmt.setInt(2, 1002);

            int affectedRows = updateRegistrationStmt.executeUpdate();

            System.out.println(affectedRows + " lastnames have been updated.");
            return affectedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
