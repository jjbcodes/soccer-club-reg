import java.util.Scanner;

public class FamilyMember {

    // variables needed for the family member
    String firstName_family;
    String lastName_family;
    String homeAddress;
    String city;
    String postalCode;
    String phoneNum;

    // constructor - the user
    public FamilyMember(String firstName, String lastName, String address, String cityName, String postal,
            String phone) {
        firstName_family = firstName;
        lastName_family = lastName;
        homeAddress = address;
        city = cityName;
        postalCode = postal;
        phoneNum = phone;
    }

    // getter
    public String getFullName() {
        return firstName_family + " " + lastName_family;
    }

    // getter
    public String getContactInfo() {
        return homeAddress + ", " + city + ", " + postalCode + ", " + phoneNum;
    }

    // setter-can be used to fix mistakes in name, or add a preferred name
    public void setName(String newFirstName, String newLastName) {
        this.firstName_family = newFirstName;
        this.lastName_family = newLastName;
    }

}


