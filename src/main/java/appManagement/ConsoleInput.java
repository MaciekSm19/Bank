package appManagement;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Locale;

public class ConsoleInput {
    private final Scanner scanner;
    public ConsoleInput(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        this.scanner.useLocale(Locale.US);
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public int getIntInput() {
        return scanner.nextInt();
    }

    public BigDecimal getBigDecimalInput() {
        return scanner.nextBigDecimal();
    }
}