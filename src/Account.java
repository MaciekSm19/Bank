import java.util.Scanner;

public class Account {
    Scanner scanner;
    private double deposit = 0;
    private String ownersLogin;

    Account(String ownersLogin) {
        this.ownersLogin = ownersLogin;
        scanner = new Scanner(System.in);
    }

    boolean checkIfUserExists(String ownersLogin) {
        if (User.user.containsKey(ownersLogin))
            return true;
        else
            return false;
    }

    void withdrawMoney() {
        System.out.print("Ile pieniedzy chcesz wyplacic? ");
        double amount = scanner.nextDouble();
        if (checkIfUserExists(ownersLogin)) {
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
        if (checkIfUserExists(ownersLogin)) {
            deposit += amount;
            System.out.println("Wplata zatwierdzona! Obecny stan konta wynosi: " + deposit);
        } else
            System.out.println("Nie mozna wykonac tej operacji.");
    }

    public String getOwnersLogin() {
        return ownersLogin;
    }
}