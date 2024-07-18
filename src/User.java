import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    private UserPersonalData userPersonalData;
    private UserContactData userContactData;
    private UserLoginData userLoginData;

    static Map<String, String> user = new HashMap<String, String>();

    public User(UserPersonalData userPersonalData, UserContactData userContactData, UserLoginData userLoginData) {
        this.userPersonalData = userPersonalData;
        this.userContactData = userContactData;
        this.userLoginData = userLoginData;
    }
}

class UserPersonalData {
    private String firstName;
    private String lastName;
    private String mothersMaidenName;
    private LocalDate dateOfBirth;
    private String pesel;

    UserPersonalData(String firstName, String lastName, String mothersMaidenName, LocalDate dateOfBirth, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.dateOfBirth = dateOfBirth;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
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