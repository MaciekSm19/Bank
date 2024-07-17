import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserOperations {
    private Adress adress;
    private User user;
    private ArrayList<User> users;
    private Scanner scanner;

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
        System.out.print("Numer telefonu: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Adres e-mail: ");
        String email = scanner.nextLine();
        adress = createAdress();
        System.out.print("\nLogin: ");
        String login = scanner.nextLine();
        System.out.print("Haslo: ");
        String password = scanner.nextLine();

        user = new User(firstName, lastName, mothersMaidenName, LocalDate.parse(dateOfBirth), pesel, phoneNumber, email, adress, login, password);

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
}