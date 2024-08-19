package appManagement;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;
    public ConsoleInput(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public int getIntInput() {
        return scanner.nextInt();
    }
}
