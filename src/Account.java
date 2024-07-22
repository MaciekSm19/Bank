import java.util.Scanner;

public class Account {
    Scanner scanner;
    private double deposit = 0;
    private String ownersLogin;

    Account(String ownersLogin) {
        this.ownersLogin = ownersLogin;
        scanner = new Scanner(System.in);
    }

    boolean checkIfUserExists(String ownersLogin) {
        return User.user.containsKey(ownersLogin);
    }

    void withdrawMoney() {
        System.out.print("Ile pieniedzy chcesz wyplacic? ");
        double amount = scanner.nextDouble();
        if (checkIfUserExists(ownersLogin)) {
            if (amount > deposit)
                System.out.println("Odmowa! Masz za malo pieniedzy na koncie (" + deposit + " zl), aby wyplacic " + amount + " zl");
            else if(amount <= deposit) {
                deposit -= amount;
                System.out.println("Wyplata zatwierdzona! Obecny stan konta wynosi: " + deposit);
            } else
                System.out.println("Odmowa! Wystapil blad");
        } else
            System.out.println("Nie mozna wykonac tej operacji.");
    }

    void depositMoney() {
        System.out.print("Ile pieniedzy chcesz wplacic? ");
        double amount = scanner.nextDouble();
        if (checkIfUserExists(ownersLogin)) {
            deposit += amount;
            System.out.println("Wplata zatwierdzona! Obecny stan konta wynosi: " + deposit);
        } else
            System.out.println("Nie mozna wykonac tej operacji.");
    }

    public String getOwnersLogin() {
        return ownersLogin;
    }

    boolean loginToAccount(User user) {
        String login;
        String password;

        do {
            System.out.print("Podaj Twoj login: ");
            login = scanner.nextLine();
            if (!checkIfUserExists(login))
                System.out.println("Nie znaleziono takiego uzytkownika. Sprobuj ponownie.");
        } while (!checkIfUserExists(login));

        int counter = 0;
        do {
            counter++;
            System.out.print("Podaj Twoje haslo: ");
            password = scanner.nextLine();
            if (!(password.equals(user.getUserLoginData().getPassword()))) {
                System.out.println("Haslo jest niepoprawne. Sprobuj jeszcze raz.");
            } else {
                break;
            }

            if (counter == 5) {
                System.out.println("Liczba prob przekroczona - odmowa dostepu.");
                break;
            }
        } while (!(login.equals(user.getUserLoginData().getLogin()) && password.equals(user.getUserLoginData().getPassword())) || counter < 5);

        if (login.equals(user.getUserLoginData().getLogin()) && password.equals(user.getUserLoginData().getPassword())) {
            System.out.println("Zalogowano pomyślnie");
            return true;
        } else {
            return false;
        }
    }
}