package accountManagement;

import appManagement.ConsoleInput;
import userManagement.UserOperations;

public class AccountMenu {
    private final UserOperations userOperations;

    public AccountMenu(UserOperations userOperations) {
        this.userOperations = userOperations;
    }
    public void accountMenu() {
        ConsoleInput consoleInput = new ConsoleInput(System.in);
        boolean loopController = true;
        do {
            System.out.println("\nWitaj w menu konta. Co chcesz zrobić?");
            System.out.println("1. Wyświetl informacje.");
            System.out.println("2. Edytuj dane.");
            System.out.println("3. Wyjdź do menu głównego.");
            System.out.print("Twój wybór: ");
            int choice = consoleInput.getIntInput();

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
