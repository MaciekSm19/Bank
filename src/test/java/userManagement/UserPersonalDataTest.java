package userManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserPersonalDataTest {
    private UserPersonalData userPersonalData;
    private boolean isValid;

    void assertValidPesel(String pesel) {
        userPersonalData = new UserPersonalData();

        userPersonalData.peselNumber = pesel;
        isValid = userPersonalData.isValidPesel();

        Assertions.assertTrue(isValid);
    }

    void assertInvalidPesel(String pesel) {
        userPersonalData = new UserPersonalData();

        userPersonalData.peselNumber = pesel;
        isValid = userPersonalData.isValidPesel();

        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselXXCentury() {
        assertValidPesel("50123100000");
        assertValidPesel("99022800000");
        assertValidPesel("30083100000");
    }

    @Test
    void testIsValidPeselCorrectPeselLengthXXCentury() {
        assertValidPesel("52022900000");
    }

    @Test
    void testIsValidPeselIncorrectPeselLengthXXCentury() {
        assertInvalidPesel("520229000");
        assertInvalidPesel("52022900000000000");
        assertInvalidPesel("1");
    }

    @Test
    void testIsValidPeselCorrectPeselLeapYearXXCentury() {
        assertValidPesel("52022900000");
        assertValidPesel("56022900000");
        assertValidPesel("60022900000");
    }

    @Test
    void testIsValidPeselIncorrectPeselNotLeapYearXXCentury() {
        assertInvalidPesel("50022900000");
        assertInvalidPesel("31022900000");
        assertInvalidPesel("99022900000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays31XXCentury() {
        assertValidPesel("50123100000");
        assertValidPesel("87103100000");
        assertValidPesel("68053100000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays31XXCentury() {
        assertInvalidPesel("500123200000");
        assertInvalidPesel("87103900000");
        assertInvalidPesel("68059900000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays30XXCentury() {
        assertValidPesel("50043000000");
        assertValidPesel("87113000000");
        assertValidPesel("68063000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays30XXCentury() {
        assertInvalidPesel("50043100000");
        assertInvalidPesel("87113100000");
        assertInvalidPesel("68063100000");
    }

    @Test
    void testIsValidPeselCorrectPeselMonthXXCentury() {
        assertValidPesel("50043000000");
        assertValidPesel("87113000000");
        assertValidPesel("68063000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMonthXXCentury() {
        assertInvalidPesel("50000100000");
        assertInvalidPesel("87993000000");
        assertInvalidPesel("68553000000");
    }

    @Test
    void testIsValidPeselCorrectPeselDayXXCentury() {
        assertValidPesel("50041200000");
        assertValidPesel("87052900000");
        assertValidPesel("68010100000");
    }

    @Test
    void testIsValidPeselIncorrectPeselDayXXCentury() {
        assertInvalidPesel("50040000000");
        assertInvalidPesel("50049900000");
        assertInvalidPesel("50045500000");
    }


    @Test
    void testIsValidPeselCorrectPeselXXICentury() {
        assertValidPesel("02243000000");
        assertValidPesel("05222000000");
        assertValidPesel("08260100000");
    }

    @Test
    void testIsValidPeselCorrectPeselLengthXXICentury() {
        assertValidPesel("02243000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselLengthXXICentury() {
        assertInvalidPesel("");
        assertInvalidPesel("000");
        assertInvalidPesel("02243000");
        assertInvalidPesel("022430000000000");

    }

    @Test
    void testIsValidPeselCorrectPeselLeapYearXXICentury() {
        assertValidPesel("04222900000");
        assertValidPesel("08222900000");
        assertValidPesel("12222900000");
    }

    @Test
    void testIsValidPeselIncorrectPeselNotLeapYearXXICentury() {
        assertInvalidPesel("02222900000");
        assertInvalidPesel("01222900000");
        assertInvalidPesel("05222900000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays31XXICentury() {
        assertValidPesel("02213100000");
        assertValidPesel("05283100000");
        assertValidPesel("08303100000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays31XXICentury() {
        assertInvalidPesel("02213200000");
        assertInvalidPesel("05283900000");
        assertInvalidPesel("08309900000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays30XXICentury() {
        assertValidPesel("02243000000");
        assertValidPesel("05263000000");
        assertValidPesel("08313000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays30XXICentury() {
        assertInvalidPesel("02243100000");
        assertInvalidPesel("05263900000");
        assertInvalidPesel("08319900000");
    }

    @Test
    void testIsValidPeselCorrectPeselMonthXXICentury() {
        assertValidPesel("02313000000");
        assertValidPesel("05261600000");
        assertValidPesel("08310100000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMonthXXICentury() {
        assertInvalidPesel("02203000000");
        assertInvalidPesel("02403000000");
        assertInvalidPesel("02993000000");
    }

    @Test
    void testIsValidPeselCorrectPeselDayXXICentury() {
        assertValidPesel("02253100000");
        assertValidPesel("05280800000");
        assertValidPesel("08311100000");
    }

    @Test
    void testIsValidPeselIncorrectPeselDayPeselXXICentury() {
        assertInvalidPesel("02259000000");
        assertInvalidPesel("02259990000");
        assertInvalidPesel("02259550000");
    }

    void assertValidConversion(String pesel, LocalDate expectedDate) {
        userPersonalData = new UserPersonalData();

        userPersonalData.peselNumber = pesel;
        userPersonalData.convertPeselToDateOfBirth();

        Assertions.assertEquals(userPersonalData.getDateOfBirth(), expectedDate);
    }

    @Test
    void testConvertPeselToDateOfBirthCorrectBasicDateXXCentury() {
        assertValidConversion("50010100000", LocalDate.parse("1950-01-01"));
        assertValidConversion("33062100000", LocalDate.parse("1933-06-21"));
        assertValidConversion("79112600000", LocalDate.parse("1979-11-26"));
    }

    @Test
    void testConvertPeselToDateOfBirthCorrectLeapYearXXCentury() {
        assertValidConversion("52022900000", LocalDate.parse("1952-02-29"));
        assertValidConversion("56022900000", LocalDate.parse("1956-02-29"));
        assertValidConversion("60022900000", LocalDate.parse("1960-02-29"));
    }

    @Test
    void testConvertPeselToDateOfBirthCorrectNotLeapYearXXCentury() {
        assertValidConversion("61022800000", LocalDate.parse("1961-02-28"));
        assertValidConversion("50022800000", LocalDate.parse("1950-02-28"));
        assertValidConversion("79022800000", LocalDate.parse("1979-02-28"));
    }

    @Test
    void testConvertPeselToDateOfBirthCorrectMaximumDays31XXCentury() {
        assertValidConversion("52033100000", LocalDate.parse("1952-03-31"));
        assertValidConversion("52053100000", LocalDate.parse("1952-05-31"));
        assertValidConversion("52073100000", LocalDate.parse("1952-07-31"));
    }

    @Test
    void testConvertPeselToDateOfBirthCorrectMaximumDays30XXCentury() {
        assertValidConversion("52043000000", LocalDate.parse("1952-04-30"));
        assertValidConversion("52063000000", LocalDate.parse("1952-06-30"));
        assertValidConversion("52093000000", LocalDate.parse("1952-09-30"));
    }
}