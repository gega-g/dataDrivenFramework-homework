package ge.tbc.tbcitacademy.registrationDatabase.steps;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;
import ge.tbc.tbcitacademy.util.GeneratePhoneNumber;
import ge.tbc.tbcitacademy.util.UserRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public static class InsertFourInRegistration {
        int affectedRows = 0;
        public int insert() {
            String SQL = "INSERT INTO RegistrationData VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<UserRegistration> registrations = getUserRegistrations();
            try (Connection conn = MSSQLConnection.connect();
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
                for (UserRegistration registration : registrations) {
                    setPreparedStatement(preparedStatement, registration);
                    preparedStatement.executeUpdate();
                }

                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " rows have been affected.");
                return affectedRows;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public List<UserRegistration> getUserRegistrations() {
            List<UserRegistration> registrations = new ArrayList<>();
            registrations.add(new UserRegistration(1007, "Niangi", "Wurwumia", "female", "Serene Pad 64G", "someaddress13", "someaddress14", "Chxorowyu", "124129127", "1459124702"));
            registrations.add(new UserRegistration(1008, "Guja", "Uzarmazarashvili", "male", "Mega 123 Large screen", "someaddress15", "someaddress16", "Saqobo", "125235950", "502849345"));
            registrations.add(new UserRegistration(1009, "Gela", "Gnolidze", "male", "Mega 123 Medium screen", "someaddress17", "someaddress18", "Gurjaani", "0958737894", "3993847304"));
            registrations.add(new UserRegistration(1010, "Aleko", "Elisashvili", "male", "Serene Pad 32G", "someaddress19", "someaddress20", "UFC", "12488593095", "5020474739"));
            return registrations;
        }

        public void setPreparedStatement(PreparedStatement preparedStatement, UserRegistration registration) throws SQLException {
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
            affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        }
    }
}
