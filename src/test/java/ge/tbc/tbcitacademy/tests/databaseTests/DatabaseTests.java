package ge.tbc.tbcitacademy.tests.databaseTests;

import ge.tbc.tbcitacademy.registrationDatabase.steps.DatabaseSteps;
import ge.tbc.tbcitacademy.pages.TechcanvasPage;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseTests {
    @Test
    public void dataTest() {
        TechcanvasPage techcanvasPage = new TechcanvasPage();
        techcanvasPage.navigateToTechCanvas();

        try {
            ResultSet resultSet = DatabaseSteps.selectAllFromRegistrationData();
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String gender = resultSet.getString("gender");
                String device = resultSet.getString("device");
                String address1 = resultSet.getString("address1");
                String address2 = resultSet.getString("address2");
                String city = resultSet.getString("city");
                String contact1 = resultSet.getString("contact1");
                String contact2 = resultSet.getString("contact2");

                techcanvasPage.firstnameField.setValue(firstName);
                techcanvasPage.lastnameField.setValue(lastName);
                if (gender.equalsIgnoreCase("male")) {
                    techcanvasPage.genderButton.selectRadio("Male");
                } else if (gender.equalsIgnoreCase("female")) {
                    techcanvasPage.genderButton.selectRadio("Female");
                }
                techcanvasPage.deviceDropdown.selectOption(device);
                techcanvasPage.address1Field.setValue(address1);
                techcanvasPage.address2Field.setValue(address2);
                techcanvasPage.cityField.setValue(city);
                techcanvasPage.contact1.setValue(contact1);
                techcanvasPage.contact2.setValue(contact2);

                techcanvasPage.navigateToTechCanvas();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
