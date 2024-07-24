import java.util.Scanner;

/**
 * <pre> Class <code>Account</code> stores and operates at user's account. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */
public class Account {
    private Scanner scanner = new Scanner(System.in);

    /**
     * <pre> Stores account's balance </pre>
     */
    private double balance = 0;

    /**
     * <pre>Checks if the user exists</pre>
     *
     * @param login
     * @return  true if user exists or false if user do not exist
     */
    boolean checkIfUserExists(String login) {
        return User.userLoginAndPassword.containsKey(login);
    }

    /**
     * <pre>Allows user withdraw money from account.</pre>
     *
     * If amount of money to withdraw is less than balance, user cannot withdraw money from the account.
     *
     * @param user  @see <code>User</code>
     */
    void withdrawMoney(User user) {
        System.out.print("Ile pieniedzy chcesz wyplacic? ");
        double amount = scanner.nextDouble();
        if (checkIfUserExists(user.getUserLoginData().getLogin())) {
            if (amount > balance)
                System.out.println("Odmowa! Masz za malo pieniedzy na koncie (" + balance + " zl), aby wyplacic " + amount + " zl");
            else if(amount <= balance) {
                balance -= amount;
                System.out.println("Wyplata zatwierdzona! Obecny stan konta wynosi: " + balance);
            } else
                System.out.println("Odmowa! Wystapil blad");
        } else
            System.out.println("Nie mozna wykonac tej operacji.");
    }

    /**
     * <pre>Allows user balance money to the account.</pre>
     *
     * @param user  @see <code>User</code>
     */
    void depositMoney(User user) {
        System.out.print("Ile pieniedzy chcesz wplacic? ");
        double amount = scanner.nextDouble();
        if (checkIfUserExists(user.getUserLoginData().getLogin())) {
            balance += amount;
            System.out.println("Wplata zatwierdzona! Obecny stan konta wynosi: " + balance);
        } else
            System.out.println("Nie mozna wykonac tej operacji.");
    }

    /**
     * <pre>Allows user login to the account.</pre>
     *
     * User inserts login and password to check if they match to the account:
     * <ul>
     * <li>Firstly checks if user exits. </li>
     * <li>Secondly allows insert password and then checks if matches to the login. If not user has 5 tries to type correct password. After 5 tries the account is blocked.</li>
     * </ul>
     *
     * @param user
     * @return  ture if user is logged to the account, false if user is not logged to the account
     */
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