import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String firstName;
    private String lastName;
    private String mothersMaidenName;
    private LocalDate dateOfBirth;
    private String pesel;
    private String phoneNumber;
    private String email;
    private Adress adress;
    private Map<String, String> user = new HashMap<String, String>();

    public User(String firstName, String lastName, String mothersMaidenName, LocalDate dateOfBirth, String pesel, String phoneNumber, String email, Adress adress, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.dateOfBirth = dateOfBirth;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;

        user.put(login, password);
    }
}

