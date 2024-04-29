package ge.tbc.tbcitacademy.registrationDatabase.dataprovider;

import ge.tbc.tbcitacademy.registrationDatabase.configuration.MSSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataProviderForRegistration {
    @org.testng.annotations.DataProvider
    public static Object[][] dataprovider(){
        try (Connection connection = MSSQLConnection.connect()){
            String SQL = """
                    select RegistrationData.firstName, RegistrationData.lastName, Registrationdata.gender, Registrationdata.city, Phones.phoneNumber 
                    from RegistrationData
                    inner join Phones on RegistrationData.id = Phone.ownerId
                    """;
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();
            Object[][] data = new Object[rowCount][resultSet.getMetaData().getColumnCount()];

            int iter = 0;
            while (resultSet.next()){
                data[iter] = new Object[] {
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("gender"),
                        resultSet.getString("city"),
                        resultSet.getString("phoneNumber"),
                };
                iter++;
            }
            return data;

        } catch (SQLException e) {
            e.printStackTrace();
            return new Object[][]{};
        }
    }
}