package ge.tbc.tbcitacademy.tests.databaseTests;

import ge.tbc.tbcitacademy.registrationDatabase.dataprovider.DataProviderForRegistration;
import ge.tbc.tbcitacademy.registrationDatabase.steps.*;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class JDBCTests {

    @Test
    public void newUsersInRegistration(){
        InsertPhoneNumbers.InsertFourInRegistration test = new InsertPhoneNumbers.InsertFourInRegistration();
        test.insert();
    }

    @Test
    public void addPhoneNumbers() throws SQLException {
        InsertPhoneNumbers insertPhoneNumbers = new InsertPhoneNumbers();
        AttachPhoneNumbersToUsers attachPhoneNumbersToUsers = new AttachPhoneNumbersToUsers();
        insertPhoneNumbers.insertPhoneNumbers();
        attachPhoneNumbersToUsers.attach();
    }

    @Test
    public void updateInfos() throws SQLException{
        UpdateRegistrationsAndPhoneNumbers update = new UpdateRegistrationsAndPhoneNumbers();
        update.update();
    }

    @Test
    public void getInfoAboutPeopleWithPhones() throws SQLException{
        GetSomeInfo info = new GetSomeInfo();
        info.info();
    }

    @Test(dataProvider = "dataprovider", dataProviderClass = DataProviderForRegistration.class)
    public void data(String firstName, String lastName, String gender, String city, String phoneNumber){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(gender);
        System.out.println(city);
        System.out.println(phoneNumber);
    }

    @Test
    public void autoCommit() throws SQLException {
        AutoCommit autoCommit = new AutoCommit();
        autoCommit.autoCommit();
    }

    @Test
    public void updateLastname() throws SQLException{
        UpdateLastname updateLastname = new UpdateLastname();
        updateLastname.update();
    }
}
