import java.util.Scanner;

public class Account {
    Scanner scanner;
    private double deposit = 0;
    private String ownerLogin;

    Account(String ownerLogin) {
        this.ownerLogin = ownerLogin;
        scanner = new Scanner(System.in);
    }

    boolean checkIfUserExists(String ownerLogin) {
        if (User.user.containsKey(ownerLogin))
            return true;
        else
            return false;
    }

    void withdrawMoney() {
        System.out.print("Ile pieniedzy chcesz wyplacic? ");
        double amount = scanner.nextDouble();
        if (checkIfUserExists(ownerLogin)) {
            if (amount > deposit)
                System.out.println("Odmowa! Masz za malo pieniedzy na koncie (" + deposit + " zl), aby wyplacic " + amount + " zl");
            else if(amount <= deposit) {
                deposit -= amount;
                System.out.println("Wyplata zatwierdzona! Obecny stan konta wynosi: " + deposit);
            } else
                System.out.println("Odmowa! Wystapil blad");
        } else
            System.out.println("Nie mozna wykonac tej operacji.");
    }

    void depositMoney() {
        System.out.print("Ile pieniedzy chcesz wplacic? ");
        double amount = scanner.nextDouble();
        if (checkIfUserExists(ownerLogin)) {
            deposit += amount;
            System.out.println("Wplata zatwierdzona! Obecny stan konta wynosi: " + deposit);
        } else
            System.out.println("Nie mozna wykonac tej operacji.");
    }
}