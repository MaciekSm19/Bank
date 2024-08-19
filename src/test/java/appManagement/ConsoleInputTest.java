package appManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

class ConsoleInputTest {
    private void stringValid(String expected, String actual) {
        InputStream inputStream = new ByteArrayInputStream(actual.getBytes());
        ConsoleInput consoleInput = new ConsoleInput(inputStream);
        assertEquals(expected, consoleInput.getStringInput());
    }
    private void intValid(int expected, String actual) {
        InputStream inputStream = new ByteArrayInputStream(actual.getBytes());
        ConsoleInput consoleInput = new ConsoleInput(inputStream);
        int result = consoleInput.getIntInput();
        assertEquals(expected, result);
    }
    private void bigDecimalValid(BigDecimal expected, String actual) {
        InputStream inputStream = new ByteArrayInputStream(actual.getBytes());
        ConsoleInput consoleInput = new ConsoleInput(inputStream);
        BigDecimal result = consoleInput.getBigDecimalInput();
        assertEquals(expected, result);
    }
    @Test
    public void testStringInput() {
        stringValid("Name", "Name");
        stringValid("Jan", "Jan");
        stringValid("Kowalski", "Kowalski");
    }
    @Test
    public void testIntInput() {
        intValid(1, "1");
        intValid(100, "100");
        intValid(21, "21");
    }
    @Test
    public void testBigDecimalInput() {
        bigDecimalValid(BigDecimal.valueOf(11.22), "11.22");
        bigDecimalValid(BigDecimal.valueOf(1100012.22000021), "1100012.22000021");
        bigDecimalValid(BigDecimal.valueOf(213489.98874), "213489.98874");
    }
}