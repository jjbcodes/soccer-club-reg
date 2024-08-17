import java.util.Scanner;

public class Main {

    // method to get an input with minimum required number of characters
    static String getInput(Scanner keyboard, String description, int length) {

        String input;
        System.out.println("Please enter " + description);
        input = keyboard.next();

        Boolean valid = false;
        while (!valid) {
            // check if the length appropriate:
            if (input.length() < length) {
                valid = false;
                System.out.println(description + "should have at least " + length + " characters. Enter again: ");
                input = keyboard.next();
            } else {
                valid = true;
            }
        }
        return input;
    }

    // method to add new family members
    static int addFamilyMembers(Scanner keyboard) {
        int input;
        System.out.println("How many family members do you wish to add? You can add up to 20.");
        input = keyboard.nextInt();
        boolean validInput = false;
        while (!validInput) {
            if (input > 20 || input < 1) {
                System.out.println("Invalid number. How many family members do you wish to add? You can add up to 20.");
                input = keyboard.nextInt();
            } else {
                validInput = true;
            }
        }

        return input;
    }

    // method to get the relationship between the family member and the new member
    static String getRelationship(Scanner keyboard) {
        String[] validRelationships = { "Father", "Mother", "Grandfather", "Grandmother", "Tutor", "Partner", "Friend",
                "Other" };
        System.out.println("Please Enter the Relationship between the family member and the new club member: \n"
                + "1 - Father \n"
                + "2 - Mother \n"
                + "3 - Grandfather \n"
                + "4 - Grandmother \n"
                + "5 - Tutor \n"
                + "6 - Partner \n"
                + "7 - Friend \n"
                + "8 - Other \n"
                + "Please enter your choice (1-8)");
        int input = keyboard.nextInt();

        while (input < 1 || input > 8) {
            System.out.println("Not a valid input. Enter a value between 1 - 8");
            input = keyboard.nextInt();
        }

        return validRelationships[input - 1];
    }

    // method to get the member's gender
    static String getGender(Scanner keyboard) {
        String input;
        System.out.println("Please enter the new member's gender (m/f):");
        input = keyboard.next();

        Boolean valid = false;
        String male = "M";
        String female = "F";
        String membersGender = "Unknown";

        while (!valid) {
            // check if the gender input is valid:
            if (!(male.equals(input.toUpperCase()) || female.equals(input.toUpperCase()))) {
                valid = false;
                System.out.println("Invalid value. Enter M or F for gender: ");
                input = keyboard.next();
            } else {
                valid = true;
                if (male.equals(input.toUpperCase())) {
                    membersGender = "Boy's team";
                } else if (female.equals(input.toUpperCase())) {
                    membersGender = "Girl's team";
                }
            }
        }
        return membersGender;
    }

    // method to get the birthday (year, month, day)
    static int getBirthday(Scanner keyboard, String description, int min, int max) {
        int input;
        String continueOrNot;
        System.out.println("Please enter " + description);
        input = keyboard.nextInt();
        String yes = "Y";
        String no = "N";

        Boolean valid = false;
        while (!valid) {
            // check if the input is appropriate:
            if (input < min || input > max) {
                valid = false;
                System.out.println(description + " need to be entered. Do you want to continue? (enter Y/N) ");
                continueOrNot = keyboard.next();
                if (no.equals(continueOrNot.toUpperCase())) {
                    // terminate system
                    System.out.println("The program will now terminate.");
                    System.exit(0);
                } else if (yes.equals(continueOrNot.toUpperCase())) {
                    System.out.println("Please enter " + description);
                    input = keyboard.nextInt();
                } else {
                    // terminate system
                    System.out.println("Not a valid input. The program will now terminate.");
                    System.exit(0);
                }
            } else {
                valid = true;
            }
        }
        return input;
    }

    // method to find out if the new member wants to sign up for a tournament
    static boolean wantToContinue(Scanner keyboard, int memberNum) {
        int input;
        System.out.println(
                "At this time, do you wish to register the new member " + (memberNum + 1)
                        + " for a tournament? Enter 1 for yes, and 0 for no.");
        input = keyboard.nextInt();

        Boolean valid = false;
        Boolean continueBoolean = false;

        while (!valid) {
            // check if the input is valid:
            if (input != 0 && input != 1) {
                valid = false;
                System.out.println(
                        "Invalid value. Enter Enter 1 for yes, 0 for no to indicate if you wish to register the new member for a tournament: ");
                input = keyboard.nextInt();
            } else if (input == 1) {
                valid = true;
                continueBoolean = true;
            } else {
                valid = true;
            }
        }
        return continueBoolean;
    }

    // method to ask yes/no question
    static boolean yesOrNo(Scanner keyboard) {
        String input;
        System.out.println("Do you want to continue? Enter Y or N (in capital letters):");
        input = keyboard.next();
        String yes = "Y";
        String no = "N";
        Boolean valid = false;

        while (!valid) {
            if (!yes.equals(input) && !no.equals(input)) {
                System.out.println("Invalid value. Do you want to continue? Enter Y or N:");
                input = keyboard.next();
            } else {
                valid = true;
            }
        }
        return yes.equals(input);
    }

    // method to get the contact information
    static String[] getContact(Scanner keyboard) { // prompt the user for the address
        String homeAddress = getInput(keyboard, "the address without any space ", 2);

        // prompt the user for the city
        String city = getInput(keyboard, "the name of the city", 2);

        // prompt the user's postal code
        String postalCode = getInput(keyboard, "postal code without any space ", 6);

        // prompt the user's phone number
        String phoneNum = getInput(keyboard, "phone number without any space ", 10);

        String[] result = { homeAddress, city, postalCode, phoneNum };
        return result;
    }

    // method to sign up the new member for a tournament
    static String[] tournamentSignup(Scanner keyboard) {
        String[] tournamentDates = { "Period1", "Period2", "Period3" };
        String signedUpFor = "";
        boolean moreTournaments = true;
        int countHowManyPeriods = 0;
        int costForSignup = 0;
        int input;

        while (moreTournaments && countHowManyPeriods < 3) {
            System.out.println(
                    "The available tournament periods are as follows. Please enter you choice between 1-3: \n"
                            + "1: Period 1, June 3-28 \n"
                            + "2: Period 2, July 1-26 \n"
                            + "3: Period 3, Aug 5-30 \n");
            input = keyboard.nextInt();

            while (input < 1 || input > 3 || signedUpFor.contains(tournamentDates[input - 1])) {
                System.out.println("Not a valid input. Enter a value between 1 - 3");
                input = keyboard.nextInt();
            }

            // calculate the total cost and record which period the member signed up for
            costForSignup += 100;
            signedUpFor += tournamentDates[input - 1] + " ";
            countHowManyPeriods++;

            // ask if the new member wants to sign up for more tournaments
            if (countHowManyPeriods < 3) {
                System.out.println("At this point, you can continue and sign up for more tournaments.");
                moreTournaments = yesOrNo(keyboard);
            } else {
                moreTournaments = false;
            }

        }
        String[] result = { signedUpFor, String.valueOf(costForSignup) };
        return result;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // *********************************************** */
        // ****Ask for the user's info *****
        // *********************************************** */
        // prompt the family member for the first name
        String firstName_family = getInput(keyboard, "Family member\'s first name", 2);
        // prompt the family member for the last name
        String lastName_family = getInput(keyboard, "Family member\'s last name", 2);
        // prompt the family member for the address
        String homeAddress = getInput(keyboard, "the address without any space ", 2);
        // prompt the user for the city
        String city = getInput(keyboard, "the name of the city", 2);
        // prompt the user's postal code
        String postalCode = getInput(keyboard, "postal code without any space ", 6);
        // prompt the user's phone number
        String phoneNum = getInput(keyboard, "phone number without any space ", 10);
        // create a new instance (for the family member's info)
        FamilyMember familyMember = new FamilyMember(firstName_family, lastName_family, homeAddress, city, postalCode,
                phoneNum);

        // *********************************************** */
        // ****Add new family member(s) to the soccer club****
        // *********************************************** */

        // ask how many family members will be added (up to 20)
        int howManyFamilyMembers = addFamilyMembers(keyboard);
        // ask for the info and store them in arrays (then create instances with teh
        // information)
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

        // create an array of objects( of the new members in a loop)
        NewClubMember[] newMembers = new NewClubMember[howManyFamilyMembers];

        for (int i = 0; i < howManyFamilyMembers; i++) {
            // prompt for the new member's first name
            firstName_new = getInput(keyboard, "the new member " + (i + 1) + "'s first name", 2);
            // prompt the family member for the last name
            lastName_new = getInput(keyboard, "the new member " + (i + 1) + "'s last name", 2);
            // prompt the family member to specify relationship with the new member
            relationship_fam = getRelationship(keyboard);
            // ask for the new member's year of birth
            yearOfBirth = getBirthday(keyboard, "new member's year of birth, between 2014 and 2024", 2014, 2024);
            // ask for the new member's month of birth
            monthOfBirth = getBirthday(keyboard, "new member's month of birth, between 1 and 12", 1, 12);
            // ask for the new member's day of birth
            dayOfBirth = getBirthday(keyboard, "new member's day of birth, between 1 and 31", 1, 31);
            // ask for the new member's gender
            gender = getGender(keyboard);
            // assign a new registration number (4 digits) for the new member
            regNum = (int) (Math.random() * 9999);
            // get new member's address
            homeAddress_new = getInput(keyboard, "the address without any space ", 2);
            // new member's city
            city_new = getInput(keyboard, "the name of the city", 2);
            // new member's postal code
            postalCode_new = getInput(keyboard, "postal code without any space ", 6);
            // new member's phone number
            phoneNum_new = getInput(keyboard, "phone number without any space ", 10);
            // use the constructor to create a new object
            // push the member object into the array of objects
            newMembers[i] = new NewClubMember(firstName_new,
                    lastName_new, relationship_fam, yearOfBirth, monthOfBirth,
                    dayOfBirth, gender, regNum, homeAddress_new, city_new,
                    postalCode_new, phoneNum_new);
        }

        // display the new member(s)'s details (in a loop)
        for (int i = 0; i < howManyFamilyMembers; i++) {
            System.out.println("New Club Member " + (i + 1) + " Registration Details is as follows: \n"
                    + "************************* \n"
                    + newMembers[i].getFullName() + " with new MYSC " + newMembers[i].getGender() + " membership #"
                    + newMembers[i].getRegNum() + "\n"
                    + "Lives at " + newMembers[i].getAddress() + "\n"
                    + "Telephone: " + newMembers[i].getPhoneNum() + "\n"
                    + "************************* \n"
                    + "This Member is Registered Under: \n"
                    + familyMember.getFullName() + ", " + newMembers[i].getRelationship()
                    + " of the new MYSC member \n"
                    + "************************* \n");
        }

        /*
         * ****************************
         * Register the new member(s) for one of the tournament periods
         * ****************************
         */
        for (int i = 0; i < howManyFamilyMembers; i++) {
            // ask the user if they want to register the new club member in a tournament
            // period

            boolean continueReg = wantToContinue(keyboard, (i));

            if (!continueReg) {
                System.out.println(
                        "Call 123-123-1234 for more info.");
                // terminate system
                System.exit(0);
            }

            // give the user an option to register in one of the tournament periods:
            String[] signUpResult = tournamentSignup(keyboard);

            System.out.println(newMembers[i].getFullName() + " is now registered for the tournament: "
                    + signUpResult[0] + "\n"
                    + "The cost is " + signUpResult[1] + ", due at the end of this month.\n"
                    + "Thank you for using our system and scroll down for a sorted list of the new members.");
        }

        /*
         * ///////////////////////////////////////
         * PART 2 - LIST OF THE NEW MEMBERS (SORTED)
         */
        //////////////////////////////////////////

        // get all the full names of the new members (using the getter), and store them
        // in an array
        // step 1: create an array with full names of the new members
        String[] fullName_new = new String[howManyFamilyMembers];
        // step 2: use a loop with the appropriate getter (getFullName)
        for (int i = 0; i < howManyFamilyMembers; i++) {
            fullName_new[i] = newMembers[i].getFullName();
        }
        // sort the names (first name first, and then last name)
        // step 1: copy the array of full names (so I can sort them without changing the
        // original array)
        String[] sortedFullName_new = fullName_new;
        // step 2: sort the names
        for (int i = 0; i < howManyFamilyMembers; i++) {
            for (int j = i + 1; j < howManyFamilyMembers; j++) {
                if (sortedFullName_new[i].compareTo(sortedFullName_new[j]) > 0) {
                    String tempStr = sortedFullName_new[j];
                    sortedFullName_new[j] = sortedFullName_new[i];
                    sortedFullName_new[i] = tempStr;
                }
            }
        }
        // print the list of sorted names
        System.out.println("Following is the list of the new Members: \n"
                + "-----------------------------------------------------");
        for (int i = 0; i < howManyFamilyMembers; i++) {
            System.out.println(sortedFullName_new[i]);
        }

        // display the oldest member and the newest member
        // step 1: create an array with birthdays
        String[] fullBirthday_new = new String[howManyFamilyMembers];
        // step 2: use the getter to get full birthdays (Strings)
        for (int i = 0; i < howManyFamilyMembers; i++) {
            fullBirthday_new[i] = newMembers[i].getBirthday();
        }
        // create a copy of array (so I can sort them without changing the original
        // array)
        String[] sortedBirthday_new = fullBirthday_new;
        // create another array to store the indices (so that I can match the birthdays
        // with names)
        int[] indices = new int[howManyFamilyMembers];
        // sort the birthdays
        for (int i = 0; i < howManyFamilyMembers; i++) {
            for (int j = i + 1; j < howManyFamilyMembers; j++) {
                if (sortedBirthday_new[i].compareTo(sortedBirthday_new[j]) > 0) {
                    // sort birthdays
                    String tempStr = sortedBirthday_new[j];
                    sortedBirthday_new[j] = sortedBirthday_new[i];
                    sortedBirthday_new[i] = tempStr;
                    // sort indices
                    indices[i] = j;
                    indices[j] = i;
                }
            }
        }
        // youngest new member's birthday
        String youngestBirthday = sortedBirthday_new[howManyFamilyMembers - 1];
        String youngestName = fullName_new[indices[howManyFamilyMembers - 1]];
        // oldest new member's birthday
        String oldestBirthday = sortedBirthday_new[0];
        String oldestName = fullName_new[indices[0]];
        // print the names of the youngest club member and the oldest club member
        System.out.println("-----------------------------------------------------\n"
                + "The youngest new club member, who is born on " + youngestBirthday + ", is: " + youngestName);
        System.out.println("-----------------------------------------------------\n"
                + "The oldest new club member, who is born on " + oldestBirthday + ", is: " + oldestName);
        //
        // close keyboard
        keyboard.close();
    }
}