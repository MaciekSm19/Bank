import java.util.Scanner;

public class AccountMenu {
    public void accountMenu() {
        Scanner scanner = new Scanner(System.in);
        UserOperations userOperations = new UserOperations();

        boolean loopController = true;
        do {
            System.out.println("\nWitaj w menu konta. Co chcesz zrobić?");
            System.out.println("1. Wyświetl informacje.");
            System.out.println("2. Edytuj dane.");
            System.out.println("3. Wyjdź do menu głównego.");
            System.out.print("Twój wybór: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userOperations.getUserInfo(userOperations.users.get(0));
                    break;
                case 2:
                    userOperations.editUserData(userOperations.users.get(0));
                    break;
                case 3:
                    System.out.println("Wracam do menu głównego.");
                    loopController = false;
                    break;
            }
        } while (loopController);
    }
}
