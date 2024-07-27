import java.util.Scanner;

public class AccountMenu {
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
