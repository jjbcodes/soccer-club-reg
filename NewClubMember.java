import java.util.Scanner;

public class NewClubMember {
    // variables needed for the new member
    String firstName_new;
    String lastName_new;
    String relationship_fam;
    int yearOfBirth;
    int monthOfBirth;
    int dayOfBirth;
    String gender;
    int regNum;
    String homeAddress_new;
    String city_new;
    String postalCode_new;
    String phoneNum_new;

    // constructor - new member
    public NewClubMember(String firstName, String lastName, String relationship, int year, int month, int day,
            String gen, int registration, String address, String cityName, String postal,
            String phone) {
        firstName_new = firstName;
        lastName_new = lastName;
        relationship_fam = relationship;
        yearOfBirth = year;
        monthOfBirth = month;
        dayOfBirth = day;
        gender = gen;
        regNum = registration;
        homeAddress_new = address;
        city_new = cityName;
        postalCode_new = postal;
        phoneNum_new = phone;
    }

    // getter - full name
    public String getFullName() {
        return firstName_new + " " + lastName_new;
    }

    // getter - birthday
    public String getBirthday() {
        return yearOfBirth + "/" + monthOfBirth + "/" + dayOfBirth;
    }

    // getter - gender
    public String getGender() {
        return gender;
    }

    // getter - registration number
    public int getRegNum() {
        return regNum;
    }

    // getter - address
    public String getAddress() {
        return homeAddress_new + " " + city_new + " " + postalCode_new;
    }

    // getter - phone number
    public String getPhoneNum() {
        return phoneNum_new;
    }

    // getter - relationship with the family member (the main user)
    public String getRelationship() {
        return relationship_fam;
    }

    // setter-can be used to fix mistakes in name or add a preferred name
    public void setName(String newFirstName, String newLastName) {
        this.firstName_new = newFirstName;
        this.lastName_new = newLastName;
    }

}
