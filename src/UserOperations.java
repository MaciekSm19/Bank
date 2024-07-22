import java.util.ArrayList;
import java.util.Scanner;

public class UserOperations {
    private Adress adress;
    private User user;
    private UserPersonalData userPersonalData;
    private UserContactData userContactData;
    private UserLoginData userLoginData;
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
            userPersonalData.setPesel(pesel);
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

    void getUserInfo(User user) {
        getUserPersonalDataInfo(user);
        getUserConcactData(user);
        getUserAdress(user);
        getLoginData(user);
    }

    private void getLoginData(User user) {
        System.out.println("\nDane logowania: " );
        System.out.println("Login: " + user.getUserLoginData().getLogin());
        System.out.println("Haslo: *********");
    }

    private void getUserAdress(User user) {
        System.out.println("\nAdres: ");
        System.out.println("Miasto: " + user.getUserContactData().getAdress().getCity());
        System.out.println("Ulica i numer domu: " + user.getUserContactData().getAdress().getStreet() + " " + user.getUserContactData().getAdress().getHouseNumber());
        System.out.println("Kod pocztowy: " + user.getUserContactData().getAdress().getPostalCode());
    }

    private void getUserConcactData(User user) {
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
                    editUserAdress(user);
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

    private void editUserAdress(User user) {
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
                    System.out.println("Twoje miasto: " + user.getUserContactData().getAdress().getCity());
                    System.out.print("Podaj nowe miasto: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAdress().setCity(valueToSet);
                    break;
                case 2:
                    System.out.println("Twoja ulica: " + user.getUserContactData().getAdress().getStreet());
                    System.out.print("Podaj nowa ulice: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAdress().setStreet(valueToSet);
                    break;
                case 3:
                    System.out.println("Twoj numer domu: " + user.getUserContactData().getAdress().getHouseNumber());
                    System.out.print("Podaj nowy numer domu: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAdress().setHouseNumber(valueToSet);
                    break;
                case 4:
                    System.out.println("Twoj kod pocztowy: " + user.getUserContactData().getAdress().getPostalCode());
                    System.out.print("Podaj nowy kod pocztowy: ");
                    valueToSet = scanner.nextLine();
                    user.getUserContactData().getAdress().setPostalCode(valueToSet);
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
}