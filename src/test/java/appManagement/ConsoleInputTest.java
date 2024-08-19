package appManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
        String value = "1";
        InputStream inputStream = new ByteArrayInputStream(value.getBytes());
        ConsoleInput consoleInput = new ConsoleInput(inputStream);
        int result = consoleInput.getIntInput();
        assertEquals(1, result);
    }
}