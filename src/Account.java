import java.util.Scanner;

public class Account {
    private final Scanner scanner = new Scanner(System.in);
    private double balance = 0;

    boolean checkIfUserExists(String login) {
        return User.userLoginAndPassword.containsKey(login);
    }

    void withdrawMoney(User user) {
        if (checkIfUserExists(user.getUserLoginData().getLogin())) {
            System.out.print("Ile pieniędzy chcesz wypłacić? ");
            double amount = scanner.nextDouble();
            if (amount > balance)
                System.out.println("Odmowa! Masz za malo pieniędzy na koncie (" + balance + " zl), aby wypłacić " + amount + " zl");
            else if (amount <= balance) {
                balance -= amount;
                System.out.println("Wyplata zatwierdzona! Obecny stan konta wynosi: " + balance);
            } else
                System.out.println("Odmowa! Wystąpił błąd");
        } else
            System.out.println("Nie można wykonać tej operacji.");
    }

    void depositMoney(User user) {
        if (checkIfUserExists(user.getUserLoginData().getLogin())) {
            System.out.print("Ile pieniędzy chcesz wpłacić? ");
            double amount = scanner.nextDouble();
            balance += amount;
            System.out.println("Wplata zatwierdzona! Obecny stan konta wynosi: " + balance);
        } else
            System.out.println("Nie można wykonać tej operacji.");
    }

    boolean loginToAccount(User user) {
        String login;
        String password;

        do {
            System.out.print("Podaj Twój login: ");
            login = scanner.nextLine();
            if (!checkIfUserExists(login))
                System.out.println("Nie znaleziono takiego użytkownika. Spróbuj ponownie.");
        } while (!checkIfUserExists(login));

        int counter = 0;
        do {
            counter++;
            System.out.print("Podaj Twoje hasło: ");
            password = scanner.nextLine();
            if (!(password.equals(user.getUserLoginData().getPassword()))) {
                System.out.println("Hasło jest niepoprawne. Spróbuj jeszcze raz.");
            } else {
                break;
            }

            if (counter == 5) {
                System.out.println("Liczba prob przekroczona - odmowa dostępu.");
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