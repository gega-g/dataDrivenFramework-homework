package ge.tbc.tbcitacademy.util;

public class UserRegistration {
    public final int id;
    public final String firstName;
    public final String lastName;
    public final String gender;
    public final String deviceModel;
    public final String address1;
    public final String address2;
    public final String city;
    public final String phoneNumber;
    public final String idNumber;

    public UserRegistration(int id, String firstName, String lastName, String gender, String deviceModel, String address1, String address2, String city, String phoneNumber, String idNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.deviceModel = deviceModel;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
    }
}