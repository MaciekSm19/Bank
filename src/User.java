import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    private final UserPersonalData userPersonalData;
    private final UserContactData userContactData;
    private final UserLoginData userLoginData;

    static Map<String, String> user = new HashMap<>();

    public User(UserPersonalData userPersonalData, UserContactData userContactData, UserLoginData userLoginData) {
        this.userPersonalData = userPersonalData;
        this.userContactData = userContactData;
        this.userLoginData = userLoginData;
        user.put(userLoginData.getLogin(), userLoginData.getPassword());
    }

    public UserLoginData getUserLoginData() {
        return userLoginData;
    }

    public UserPersonalData getUserPersonalData() {
        return userPersonalData;
    }

    public UserContactData getUserContactData() {
        return userContactData;
    }
}

class UserPersonalData {
    private String firstName;
    private String lastName;
    private String mothersMaidenName;
    private LocalDate dateOfBirth;
    private String pesel;

    UserPersonalData(String firstName, String lastName, String mothersMaidenName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
    }

    boolean isValidPesel() {
        int maxDayValue = 28;
        int year = Integer.valueOf(String.valueOf(pesel.charAt(0)) + pesel.charAt(1));
        int month = Integer.valueOf(String.valueOf(pesel.charAt(2)) + pesel.charAt(3));
        int day = Integer.valueOf(String.valueOf(pesel.charAt(4)) + pesel.charAt(5));

        if (month == 2 || month == 22) {
            if (year % 4 == 0)
                maxDayValue = 29;
            else
                maxDayValue = 28;
        }
        else if ((month <= 7 || (month <= 27 && month >= 21)) && month % 2 == 1)
            maxDayValue = 31;
        else if ((month <= 7 || (month <= 27 && month >= 21)) && month % 2 == 0)
            maxDayValue = 30;
        else if (((month >= 8  && month <= 12) || month >= 28) && month % 2 == 0)
            maxDayValue = 31;
        else if (((month >= 8  && month <= 12) || month >= 28) && month % 2 == 1)
            maxDayValue = 30;

        boolean isValidLength = pesel.length() == 11;
        boolean isValidMonth = Character.getNumericValue(pesel.charAt(2)) <= 3 && (((Character.getNumericValue(pesel.charAt(2)) == 0 || Character.getNumericValue(pesel.charAt(2)) == 1) && Character.getNumericValue(pesel.charAt(3)) <= 2) || (Character.getNumericValue(pesel.charAt(2)) >= 0 || Character.getNumericValue(pesel.charAt(3)) == 2));
        boolean isValidDay = (Character.getNumericValue(pesel.charAt(4)) <= 3 && ((Character.getNumericValue(pesel.charAt(4)) == 3) && (Character.getNumericValue(pesel.charAt(5)) == 0) || Character.getNumericValue(pesel.charAt(5)) == 1) || ((Character.getNumericValue(pesel.charAt(4)) <= 2) && Character.getNumericValue(pesel.charAt(5)) >= 0)) && day <= maxDayValue;

        if (!isValidLength) {
            System.out.println("Dlugosc numeru PESEL jest niepoprawna. Sprobuj jeszcze raz.");
            return false;
        }
        if (!isValidMonth) {
            System.out.println("3 lub 4 (zapis miesiaca urodzenia) cyfra numeru PESEL jest niepoprawna. Sprobuj jeszcze raz.");
            return false;
        }
        if (!isValidDay) {
            System.out.println("5 lub 6 (zapis dnia urodzenia) cyfra numeru PESEL jest niepoprawna. Sprobuj jeszcze raz.");
            return false;
        }
        return isValidLength && isValidMonth && isValidDay;
    }

    void convertPeselToDateOfBirth() {
        String year = null;
        String month = null;

        if (Character.getNumericValue(pesel.charAt(2)) == 1 || Character.getNumericValue(pesel.charAt(2)) == 0) {
            year = "19" + pesel.charAt(0) + pesel.charAt(1);
            month = String.valueOf(pesel.charAt(2)) + pesel.charAt(3);
        } else if(Character.getNumericValue(pesel.charAt(2)) == 2 || Character.getNumericValue(pesel.charAt(2)) == 3) {
            year = "20" + Character.getNumericValue(pesel.charAt(0)) + Character.getNumericValue(pesel.charAt(1));
            month = String.valueOf(Integer.valueOf(String.valueOf(pesel.charAt(2)) + String.valueOf(pesel.charAt(3))) - 20);

        }

        if (Integer.valueOf(month) < 10)
            month = "0" + pesel.charAt(3);

        String day = String.valueOf(pesel.charAt(4)) + pesel.charAt(5);
        if (day != null && month != null && year != null) {
            dateOfBirth = LocalDate.parse(year + "-" + month + "-" + day);
            System.out.println("Twoja data urodzin: " + dateOfBirth);
        } else
            System.out.println("Wystapil blad w konwersji");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}

class UserContactData {
    private String phoneNumber;
    private String email;
    private Adress adress;

    UserContactData(String phoneNumber, String email, Adress adress) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}

class UserLoginData {
    private String login;
    private String password;

    UserLoginData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}