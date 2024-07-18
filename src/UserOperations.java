import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserOperations {
    private Adress adress;
    private User user;
    private UserPersonalData userPersonalData;
    private UserContactData userContactData;
    private UserLoginData userLoginData;
    private final ArrayList<User> users;
    private final Scanner scanner;

    UserOperations() {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    void createUser() {
        System.out.println("Witaj w kreatorze uzytkownika. Musisz podac niezbedne dane, aby zarejestrowac sie w aplikacji baku.\n");
        System.out.print("Imie: ");
        String firstName = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String lastName = scanner.nextLine();
        System.out.print("Nazwisko panienskie matki: ");
        String mothersMaidenName = scanner.nextLine();
        System.out.print("Data urodzenia (RRRR-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("PESEL: ");
        String pesel = scanner.nextLine();
        userPersonalData = new UserPersonalData(firstName, lastName, mothersMaidenName, LocalDate.parse(dateOfBirth), pesel);

        System.out.print("Numer telefonu: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Adres e-mail: ");
        String email = scanner.nextLine();
        adress = createAdress();
        userContactData = new UserContactData(phoneNumber, email, adress);

        System.out.print("\nLogin: ");
        String login = scanner.nextLine();
        System.out.print("Haslo: ");
        String password = scanner.nextLine();
        userLoginData = new UserLoginData(login, password);

        user = new User(userPersonalData, userContactData, userLoginData);
        addUser(user);
        System.out.println("Pomyslnie utworzono uzytkownika i dodano do bazy danych!");
    }

    private Adress createAdress() {
        System.out.print("\nMiejscowosc: ");
        String city = scanner.nextLine();
        System.out.print("Ulica: ");
        String street = scanner.nextLine();
        System.out.print("Numer domu: ");
        String houseNumber = scanner.nextLine();
        System.out.print("Kod pocztowy: ");
        String postalCode = scanner.nextLine();

        return new Adress(city, street, houseNumber, postalCode);
    }

    private void addUser(User user) {
        users.add(user);
    }

    public UserLoginData getUserLoginData() {
        return userLoginData;
    }
}