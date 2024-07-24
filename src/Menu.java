import java.util.Scanner;

/**
 * <pre> Class <code>Menu</code> displays application's menu. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */
public class Menu {

    /**
     * <pre>Displays application menu options. Ask user for insert a number of an option: </pre>
     * <ol>
     *     <li>Deposit money - launches <code>depositMoney</code> method. @see <code>UserOperations#depositMoney</code></li>
     *     <li>Withdraw money - launches <code>withdrawMoney</code> method. @see <code>UserOperations#withdrawMoney</code></li>
     *     <li>Account - launches <code>accountMenu</code> method. @see <code>AccountMenu#accountMenu</code></li>
     *     <li>Exit the application - exits the application </li>
     * </ol>
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        UserOperations userOperations = new UserOperations();
        userOperations.createUser();

        Account account = new Account();

        AccountMenu accountMenu = new AccountMenu();

        System.out.println("\nZaloguj sie do aplikacji.");
        boolean isLoginToAccount = account.loginToAccount(UserOperations.users.getFirst());

        if (isLoginToAccount) {
            boolean loopController = true;
            do {
                System.out.println("\nWitaj w aplikacji banku! Wybierz, co chcesz zrobic:");
                System.out.println("1. Wplac pieniadze.");
                System.out.println("2. Wyplac.");
                System.out.println("3. Konto.");
                System.out.println("4. Wyjdz z aplikacji.");
                System.out.print("Twoj wybor: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        account.depositMoney(UserOperations.users.get(0));
                        break;
                    case 2:
                        account.withdrawMoney(UserOperations.users.get(0));
                        break;
                    case 3:
                        accountMenu.accountMenu();
                        break;
                    case 4:
                        System.out.println("Dziekuje za skorzystanie z aplikacji!");
                        loopController = false;
                        break;
                    default:
                        System.out.println("Wystapil blad!");
                        loopController = false;
                        break;
                }
            } while (loopController);
        }
    }
}
