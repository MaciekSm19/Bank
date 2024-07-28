package user;

import java.util.ArrayList;
import java.util.Scanner;

public class UserOperations {
    public ArrayList<User> users = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void createUser() {
        System.out.println("\nWitaj w kreatorze użytkownika. Musisz podać niezbędne dane, aby zarejestrować sie w aplikacji banku.\n");
        System.out.print("Imię: ");
        String firstName = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String lastName = scanner.nextLine();
        System.out.print("Nazwisko panieńskie matki: ");
        String mothersMaidenName = scanner.nextLine();
        UserPersonalData userPersonalData = new UserPersonalData(firstName, lastName, mothersMaidenName);

        String pesel;

        do {
            System.out.print("PESEL (11 cyfr): ");
            pesel = scanner.nextLine();
            userPersonalData.peselNumber = pesel;
        } while (!userPersonalData.isValidPesel());
        userPersonalData.convertPeselToDateOfBirth();

        System.out.print("\nNumer telefonu: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Adres e-mail: ");
        String email = scanner.nextLine();
        Address address = createAddress();
        UserContact userContact = new UserContact(phoneNumber, email, address);

        System.out.print("\nLogin: ");
        String login = scanner.nextLine();
        System.out.print("Hasło: ");
        String password = scanner.nextLine();
        Credentials credentials = new Credentials(login, password);

        User user = new User(userPersonalData, userContact, credentials);
        addUser(user);
        System.out.println("Pomyślnie utworzono użytkownika i dodano do bazy danych!");
    }
    public void getUserInfo(User user) {
        getUserPersonalDataInfo(user);
        getUserContact(user);
        getUserAddress(user);
        getCredentials(user);
    }
    public void editUserData(User user) {
        boolean loopController = true;
        do {
            System.out.println("\nKtóre dane chcesz edytować?");
            System.out.println("Witaj w menu konta. Co chcesz zrobić?");
            System.out.println("1. Imię.");
            System.out.println("2. Nazwisko.");
            System.out.println("3. Numer telefonu.");
            System.out.println("4. Adres e-mail.");
            System.out.println("5. Adres zamieszkania.");
            System.out.println("6. Login.");
            System.out.println("7. Hasło.");
            System.out.println("8. Wróć do menu.");
            System.out.print("Twój wybór: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            String valueToSet;

            switch (choice) {
                case 1:
                    System.out.println("Twoje imię: " + user.userPersonalData().firstName);
                    System.out.print("Podaj nowe imię: ");
                    valueToSet = scanner.nextLine();
                    user.userPersonalData().firstName = valueToSet;
                    break;
                case 2:
                    System.out.println("Twoje nazwisko: " + user.userPersonalData().lastName);
                    System.out.print("Podaj nowe nazwisko: ");
                    valueToSet = scanner.nextLine();
                    user.userPersonalData().lastName = valueToSet;
                    break;
                case 3:
                    System.out.println("Twój numer telefonu: " + user.userContact().phoneNumber);
                    System.out.print("Podaj nowy numer telefonu: ");
                    valueToSet = scanner.nextLine();
                    user.userContact().phoneNumber = valueToSet;
                    break;
                case 4:
                    System.out.println("Twój email: " + user.userContact().email);
                    System.out.print("Podaj nowy email: ");
                    valueToSet = scanner.nextLine();
                    user.userContact().email = valueToSet;
                    break;
                case 5:
                    editUserAddress(user);
                    break;
                case 6:
                    System.out.println("Twój login: " + user.credentials().login);
                    System.out.print("Podaj nowy login: ");
                    valueToSet = scanner.nextLine();
                    user.credentials().login = valueToSet;
                    break;
                case 7:
                    String password;
                    do {
                        System.out.print("W celu weryfikacji podaj stare hasło: ");
                        password = scanner.nextLine();
                        if (!(password.equals(user.credentials().login)))
                            System.out.println("Spróbuj ponownie");

                    } while (!(password.equals(user.credentials().password)));
                    System.out.print("Podaj nowe hasło: ");
                    valueToSet = scanner.next();
                    user.credentials().password = valueToSet;
                    break;
                case 8:
                    System.out.println("Wracam do menu");
                    loopController = false;
                    break;
                default:
                    loopController = false;
                    break;
            }
        } while (loopController);
    }
    private Address createAddress() {
        System.out.print("\nMiejscowość: ");
        String city = scanner.nextLine();
        System.out.print("Ulica: ");
        String street = scanner.nextLine();
        System.out.print("Numer domu: ");
        String houseNumber = scanner.nextLine();
        System.out.print("Kod pocztowy: ");
        String postalCode = scanner.nextLine();

        return new Address(city, street, houseNumber, postalCode);
    }
    private void addUser(User user) {
        users.add(user);
    }
    private void editUserAddress(User user) {
        System.out.println("\nKtóre dane chcesz edytować?");
        boolean loopController = true;
        do {
            System.out.println("Witaj w menu konta. Co chcesz zrobić?");
            System.out.println("1. Miasto.");
            System.out.println("2. Ulica.");
            System.out.println("3. Numer domu.");
            System.out.println("4. Kod pocztowy.");
            System.out.println("5. Wróć do menu edycji.");
            System.out.print("Twój wybór: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            String valueToSet;

            switch (choice) {
                case 1:
                    System.out.println("Twoje miasto: " + user.userContact().getAddress().city);
                    System.out.print("Podaj nowe miasto: ");
                    valueToSet = scanner.nextLine();
                    user.userContact().getAddress().city = valueToSet;
                    break;
                case 2:
                    System.out.println("Twoja ulica: " + user.userContact().getAddress().street);
                    System.out.print("Podaj nowa ulice: ");
                    valueToSet = scanner.nextLine();
                    user.userContact().getAddress().street = valueToSet;
                    break;
                case 3:
                    System.out.println("Twój numer domu: " + user.userContact().getAddress().houseNumber);
                    System.out.print("Podaj nowy numer domu: ");
                    valueToSet = scanner.nextLine();
                    user.userContact().getAddress().houseNumber = valueToSet;
                    break;
                case 4:
                    System.out.println("Twój kod pocztowy: " + user.userContact().getAddress().postalCode);
                    System.out.print("Podaj nowy kod pocztowy: ");
                    valueToSet = scanner.nextLine();
                    user.userContact().getAddress().postalCode = valueToSet;
                    break;
                case 5:
                    System.out.println("Wychodzę do menu");
                    loopController = false;
                    break;
                default:
                    loopController = false;
                    break;
            }
        } while (loopController);
    }
    private void getCredentials(User user) {
        System.out.println("\nDane logowania: ");
        System.out.println("Login: " + user.credentials().login);
        System.out.println("Hasło: *********");
    }
    private void getUserAddress(User user) {
        System.out.println("\nAdres: ");
        System.out.println("Miasto: " + user.userContact().getAddress().city);
        System.out.println("Ulica i numer domu: " + user.userContact().getAddress().street + " " + user.userContact().getAddress().houseNumber);
        System.out.println("Kod pocztowy: " + user.userContact().getAddress().postalCode);
    }
    private void getUserContact(User user) {
        System.out.println("\nDane kontaktowe: ");
        System.out.println("Adres e-mail: " + user.userContact().email);
        System.out.println("Numer telefonu: " + user.userContact().phoneNumber);
    }
    private void getUserPersonalDataInfo(User user) {
        System.out.println("\nDane osobowe: ");
        System.out.println("Imie i nazwisko: " + user.userPersonalData().firstName + " " + user.userPersonalData().lastName);
        System.out.println("Nazwisko panieńskie matki: *************");
        System.out.println("Data urodzenia: " + user.userPersonalData().getDateOfBirth());
        System.out.println("PESEL: *************");
    }
}