import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        UserOperations userOperations = new UserOperations();
        userOperations.createUser();

        Account account = new Account();

        AccountMenu accountMenu = new AccountMenu();

        System.out.println("\nZaloguj sie do aplikacji.");
        boolean isLoginToAccount = account.loginToAccount(userOperations.users.getFirst());

        if (isLoginToAccount) {
            boolean loopController = true;
            do {
                System.out.println("\nWitaj w aplikacji banku! Wybierz, co chcesz zrobić:");
                System.out.println("1. Wpłać pieniądze.");
                System.out.println("2. Wypłać.");
                System.out.println("3. Konto.");
                System.out.println("4. Wyjdź z aplikacji.");
                System.out.print("Twój wybór: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        account.depositMoney(userOperations.users.get(0));
                        break;
                    case 2:
                        account.withdrawMoney(userOperations.users.get(0));
                        break;
                    case 3:
                        accountMenu.accountMenu();
                        break;
                    case 4:
                        System.out.println("Dziękuje za skorzystanie z aplikacji!");
                        loopController = false;
                        break;
                    default:
                        System.out.println("Wystąpił błąd!");
                        loopController = false;
                        break;
                }
            } while (loopController);
        }
    }
}
