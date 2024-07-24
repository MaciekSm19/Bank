import java.util.ArrayList;
import java.util.Scanner;

/**
 * <pre> Class <code>UserOperations</code> operates at user's data. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */

public class UserOperations {
    /**
     * @see <code>Address</code>
     */
    private Address adress;

    /**
     * @see <code>User</code>
     */
    private User user;

    /**
     * @see <code>UserPersonalData</code>
     */
    private UserPersonalData userPersonalData;

    /**
     * @see <code>UserContactData</code>
     */
    private UserContactData userContactData;

    /**
     * @see <code>UserLoginData</code>
     */
    private UserLoginData userLoginData;

    /**
     * Contains created users
     */
    static ArrayList<User> users = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    void createUser() {
        System.out.println("\nWitaj w kreatorze uzytkownika. Musisz podac niezbedne dane, aby zarejestrowac sie w aplikacji baku.\n");
        System.out.print("Imie: ");
        String firstName = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String lastName = scanner.nextLine();
        System.out.print("Nazwisko panienskie matki: ");
        String mothersMaidenName = scanner.nextLine();
        userPersonalData = new UserPersonalData(firstName, lastName, mothersMaidenName);

        String pesel;

        do {
            System.out.print("PESEL (11 cyfr): ");
            pesel = scanner.nextLine();
            userPersonalData.setPeselNumber(pesel);
        } while (!userPersonalData.isValidPesel());
        userPersonalData.convertPeselToDateOfBirth();

        System.out.print("\nNumer telefonu: ");
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

    private Address createAdress() {
        System.out.print("\nMiejscowosc: ");
        String city = scanner.nextLine();
        System.out.print("Ulica: ");
        String street = scanner.nextLine();
        System.out.print("Numer domu: ");
        String houseNumber = scanner.nextLine();
        System.out.print("Kod pocztowy: ");
        String postalCode = scanner.nextLine();

        return new Address(city, street, houseNumber, postalCode);
    }

    /**
     * <pre> Adds userLoginAndPassword to <code>users</code> </pre>
     * @param user  userLoginAndPassword to add to <code>users</code>
     */
    private void addUser(User user) {
        users.add(user);
    }

    /**
     * Gets details about userLoginAndPassword
     * @param user  userLoginAndPassword to get information about this userLoginAndPassword
     */
    void getUserInfo(User user) {
        getUserPersonalDataInfo(user);
        getUserContactData(user);
        getUserAddress(user);
        getLoginData(user);
    }

    /**
     * <pre> Edits information about userLoginAndPassword </pre>
     * @param user  userLoginAndPassword to edit information about this userLoginAndPassword
     */
    void editUserData(User user) {
        boolean loopController = true;
        do {
            System.out.println("\nKtore dane chcesz edytowac?");
            System.out.println("Witaj w menu konta. Co chcesz zrobic?");
            System.out.println("1. Imie.");
            System.out.println("2. Nazwisko.");
            System.out.println("3. Numer telefonu.");
            System.out.println("4. Adres e-mail.");
            System.out.println("5. Adres zamieszkania.");
            System.out.println("6. Login.");
            System.out.println("7. Haslo.");
            System.out.println("8. Wroc do menu.");
            System.out.print("Twoj wybor: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            String valueToSet;

            switch (choice) {
                case 1:
                    System.out.println("Twoje imie: " + user.getUserPersonalData().getFirstName());
                    System.out.print("Podaj nowe imie: ");
                    valueToSet = scanner.nextLine();
                    user.getUserPersonalData().setFirstName(valueToSet);
                    break;
                case 2:
                    System.out.println("Twoje nazwisko: " + user.getUserPersonalData().getLastName());
                    System.out.print("Podaj nowe nazwisko: ");
                    valueToSet = scanner.nextLine();
                    user.getUserPersonalData().setLastName(valueToSet);
                    break;
                case 3:
                    System.out.println("Twoj numer telefonu: " + user.getUserContactData().getPhoneNumber());
                    System.out.print("Podaj nowy numer telefonu: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().setPhoneNumber(valueToSet);
                    break;
                case 4:
                    System.out.println("Twoj email: " + user.getUserContactData().getEmail());
                    System.out.print("Podaj nowy email: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().setEmail(valueToSet);
                    break;
                case 5:
                    editUserAddress(user);
                    break;
                case 6:
                    System.out.println("Twoj login: " + user.getUserLoginData().getLogin());
                    System.out.print("Podaj nowy login: ");
                    valueToSet = scanner.nextLine();
                    user.getUserLoginData().setLogin(valueToSet);
                    break;
                case 7:
                    String password;
                    do {
                        System.out.print("W celu weryfikacji podaj stare haslo: ");
                        password = scanner.nextLine();
                        if (!(password.equals(user.getUserLoginData().getPassword())))
                            System.out.println("Sprobuj ponownie");

                    } while (!(password.equals(user.getUserLoginData().getPassword())));
                    System.out.print("Podaj nowe haslo: ");
                    valueToSet = scanner.next();
                    user.getUserLoginData().setPassword(valueToSet);
                    break;
                case 8:
                    System.out.println("Wracam do menu");
                    loopController = false;
                    break;
                default:
                    loopController = false;
                    break;
            }
        } while(loopController);
    }

    /**
     * <pre> Edits information about userLoginAndPassword address </pre>
     * @param user  userLoginAndPassword to edit information about this userLoginAndPassword
     */
    private void editUserAddress(User user) {
        System.out.println("\nKtore dane chcesz edytowac?");
        boolean loopController = true;
        do {
            System.out.println("Witaj w menu konta. Co chcesz zrobic?");
            System.out.println("1. Miasto.");
            System.out.println("2. Ulica.");
            System.out.println("3. Numer domu.");
            System.out.println("4. Kod pocztowy.");
            System.out.println("5. Wroc do menu edycji.");
            System.out.print("Twoj wybor: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            String valueToSet;

            switch (choice) {
                case 1:
                    System.out.println("Twoje miasto: " + user.getUserContactData().getAddress().getCity());
                    System.out.print("Podaj nowe miasto: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAddress().setCity(valueToSet);
                    break;
                case 2:
                    System.out.println("Twoja ulica: " + user.getUserContactData().getAddress().getStreet());
                    System.out.print("Podaj nowa ulice: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAddress().setStreet(valueToSet);
                    break;
                case 3:
                    System.out.println("Twoj numer domu: " + user.getUserContactData().getAddress().getHouseNumber());
                    System.out.print("Podaj nowy numer domu: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAddress().setHouseNumber(valueToSet);
                    break;
                case 4:
                    System.out.println("Twoj kod pocztowy: " + user.getUserContactData().getAddress().getPostalCode());
                    System.out.print("Podaj nowy kod pocztowy: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAddress().setPostalCode(valueToSet);
                    break;
                case 5:
                    System.out.println("Wychodze do menu");
                    loopController = false;
                    break;
                default:
                    loopController = false;
                    break;
            }
        } while (loopController);
    }

    private void getLoginData(User user) {
        System.out.println("\nDane logowania: " );
        System.out.println("Login: " + user.getUserLoginData().getLogin());
        System.out.println("Haslo: *********");
    }

    private void getUserAddress(User user) {
        System.out.println("\nAdres: ");
        System.out.println("Miasto: " + user.getUserContactData().getAddress().getCity());
        System.out.println("Ulica i numer domu: " + user.getUserContactData().getAddress().getStreet() + " " + user.getUserContactData().getAddress().getHouseNumber());
        System.out.println("Kod pocztowy: " + user.getUserContactData().getAddress().getPostalCode());
    }

    private void getUserContactData(User user) {
        System.out.println("\nDane kontaktowe: " );
        System.out.println("Adres e-mail: " + user.getUserContactData().getEmail());
        System.out.println("Numer telefonu: " + user.getUserContactData().getPhoneNumber());
    }

    private void getUserPersonalDataInfo(User user) {
        System.out.println("\nDane osobowe: " );
        System.out.println("Imie i nazwisko: " + user.getUserPersonalData().getFirstName() + " " + user.getUserPersonalData().getLastName());
        System.out.println("Nazwisko panienskie matki: *************");
        System.out.println("Data urodzenia: " + user.getUserPersonalData().getDateOfBirth());
        System.out.println("PESEL: *************");
    }
}