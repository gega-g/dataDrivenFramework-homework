package ge.tbc.tbcitacademy.registrationDatabase.steps;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;
import ge.tbc.tbcitacademy.util.UserRegistration;

import java.sql.Connection;
import java.sql.SQLException;

public class AutoCommit {
    public void autoCommit() {
        try (Connection conn = MSSQLConnection.connect()) {
            conn.setAutoCommit(false);
            InsertOneInRegistration insertOneInRegistration = new InsertOneInRegistration();
            UserRegistration registration = new UserRegistration
                    (1111, "vigaca", "vigacashvili",
                            "female", "Serene Pad 64G",
                            "someaddress30", "someaddress40",
                            "Gurjaani", "634244134", "1459124702");
            insertOneInRegistration.insert(conn, registration);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}