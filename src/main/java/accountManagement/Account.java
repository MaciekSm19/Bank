package accountManagement;

import userManagement.UserOperations;

import java.util.Scanner;
import java.math.BigDecimal;

public class Account implements Comparable {
    private final Scanner scanner = new Scanner(System.in);
    private BigDecimal balance = new BigDecimal(0);
    private final UserOperations userOperations;
    
    public Account(UserOperations userOperations) {
        this.userOperations = userOperations;
    }

    @Override
    public int compareTo(Object o) {
        return this.balance.compareTo((BigDecimal) o);
    }
    public void withdrawMoney() {
        System.out.print("Ile pieniędzy chcesz wypłacić? ");
        BigDecimal amount = scanner.nextBigDecimal();
        if (balance.compareTo(amount) < 0)
            System.out.println("Odmowa! Masz za malo pieniędzy na koncie (" + balance + " zl), aby wypłacić " + amount + " zl");
        else if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            System.out.println("Wyplata zatwierdzona! Obecny stan konta wynosi: " + balance);
        } else
            System.out.println("Odmowa! Wystąpił błąd");
    }
    public void depositMoney() {
        System.out.print("Ile pieniędzy chcesz wpłacić? ");
        BigDecimal amount = scanner.nextBigDecimal();
        balance = balance.add(amount);
        System.out.println("Wplata zatwierdzona! Obecny stan konta wynosi: " + balance);
    }
    public boolean loginToAccount() {
        String login;
        String password;

        do {
            System.out.print("Podaj Twój login: ");
            login = scanner.nextLine();
            if (checkIfUserExists(login))
                System.out.println("Nie znaleziono takiego użytkownika. Spróbuj ponownie.");
        } while (checkIfUserExists(login));

        int counter = 0;
        do {
            counter++;
            System.out.print("Podaj Twoje hasło: ");
            password = scanner.nextLine();
            if (!(password.equals(userOperations.users.get(0).credentials().password))) {
                System.out.println("Hasło jest niepoprawne. Spróbuj jeszcze raz.");
            } else {
                break;
            }

            if (counter == 5) {
                System.out.println("Liczba prob przekroczona - odmowa dostępu.");
                break;
            }
        } while (!(login.equals(userOperations.users.get(0).credentials().login) && password.equals(userOperations.users.get(0).credentials().password)) || counter < 5);

        if (login.equals(userOperations.users.get(0).credentials().login) && password.equals(userOperations.users.get(0).credentials().password)) {
            System.out.println("Zalogowano pomyślnie");
            return true;
        } else {
            return false;
        }
    }
    private boolean checkIfUserExists(String login) {
        return !userOperations.users.get(0).credentials().login.equals(login);
    }
}