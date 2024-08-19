package appManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

class ConsoleInputTest {
    @Test
    public void testStringInput() {
        String value = "name";
        InputStream inputStream = new ByteArrayInputStream(value.getBytes());
        ConsoleInput consoleInput = new ConsoleInput(inputStream);
        assertEquals("name", consoleInput.getStringInput());
    }

    @Test
    public void testIntInput() {
        String value = "123";
        InputStream inputStream = new ByteArrayInputStream(value.getBytes());
        ConsoleInput consoleInput = new ConsoleInput(inputStream);
        int result = consoleInput.getIntInput();
        assertEquals(123, result);
    }

    @Test
    public void testBigDecimalInput() {
        String value = "1000.5643";
        InputStream inputStream = new ByteArrayInputStream(value.getBytes());
        ConsoleInput consoleInput = new ConsoleInput(inputStream);

        BigDecimal result = consoleInput.getBigDecimalInput();
        assertEquals(new BigDecimal("1000.5643"), result);
    }
}