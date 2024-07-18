import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        UserOperations u = new UserOperations();
        u.createUser();

        Account a = new Account(u.getUserLoginData().getLogin());

        boolean loopController = true;
        do {
            System.out.println("Witaj w aplikacji banku! Wybierz, co chcesz zrobic:");
            System.out.println("1. Wplac pieniadze.");
            System.out.println("2. Wyplac.");
            System.out.println("3. Wyjdz z aplikacji.");
            System.out.print("Twoj wybor:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    a.depositMoney();
                    break;
                case 2:
                    a.withdrawMoney();
                    break;
                case 3:
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
