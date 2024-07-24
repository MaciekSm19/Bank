import java.util.Scanner;

/**
 * <pre> Class <code>AccountMenu</code> displays account's menu options. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */
public class AccountMenu {

    /**
     * <pre>Displays account's menu options. Ask user for insert a number of an option: </pre>
     * <ol>
     *     <li>Get user info - launches <code>getUserInfo</code> method. @see <code>UserOperations#getUserInfo</code></li>
     *     <li>Edit user data - launches <code>editUserData</code> method. @see <code>UserOperations#editUserData</code></li>
     *     <li>Exit to the main menu - ends loop and goes to main menu.</li>
     * </ol>
     */
    public void accountMenu() {
        Scanner scanner = new Scanner(System.in);
        UserOperations u = new UserOperations();

        boolean loopController = true;
        do {
            System.out.println("\nWitaj w menu konta. Co chcesz zrobic?");
            System.out.println("1. Wyswietl informacje.");
            System.out.println("2. Edytuj dane.");
            System.out.println("3. Wyjdz do menu glownego.");
            System.out.print("Twoj wybor: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    u.getUserInfo(UserOperations.users.get(0));
                    break;
                case 2:
                    u.editUserData(UserOperations.users.get(0));
                    break;
                case 3:
                    System.out.println("Wracam do menu glowmnego.");
                    loopController = false;
                    break;
            }
        } while (loopController);
    }
}
