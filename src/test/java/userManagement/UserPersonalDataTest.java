package userManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserPersonalDataTest {
    private UserPersonalData userPersonalData;
    private boolean isValid;

    void assertValid(String value) {
        userPersonalData = new UserPersonalData();

        userPersonalData.peselNumber = value;
        isValid = userPersonalData.isValidPesel();

        Assertions.assertTrue(isValid);
    }

    void assertInvalid(String value) {
        userPersonalData = new UserPersonalData();

        userPersonalData.peselNumber = value;
        isValid = userPersonalData.isValidPesel();

        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselXXCentury() {
        assertValid("50123100000");
    }

    @Test
    void testIsValidPeselCorrectPeselLengthXXCentury() {
        assertValid("52022900000");
    }

    @Test
    void testIsValidPeselIncorrectPeselLengthXXCentury() {
        assertInvalid("520229000");
    }

    @Test
    void testIsValidPeselCorrectPeselLeapYearXXCentury() {
        assertValid("52022900000");
    }

    @Test
    void testIsValidPeselIncorrectPeselNotLeapYearXXCentury() {
        assertInvalid("50022900000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays31XXCentury() {
        assertValid("50123100000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays31XXCentury() {
        assertInvalid("500123200000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays30XXCentury() {
        assertValid("50043000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays30XXCentury() {
        assertInvalid("50043100000");
    }

    @Test
    void testIsValidPeselCorrectPeselMonthValueXXCentury() {
        assertValid("50043000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMonthValueXXCentury() {
        assertInvalid("50000100000");
    }

    @Test
    void testIsValidPeselCorrectPeselDayValueXXCentury() {
        assertValid("50041200000");
    }

    @Test
    void testIsValidPeselIncorrectPeselDayValueXXCentury() {
        assertInvalid("50040000000");
    }


    @Test
    void testIsValidPeselCorrectPeselXXICentury() {
        assertValid("02243000000");
    }

    @Test
    void testIsValidPeselCorrectPeselLengthXXICentury() {
        assertValid("02243000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselLengthXXICentury() {
        assertInvalid("02243000");
    }

    @Test
    void testIsValidPeselCorrectPeselLeapYearXXICentury() {
        assertValid("04222900000");
    }

    @Test
    void testIsValidPeselIncorrectPeselNotLeapYearXXICentury() {
        assertInvalid("02222900000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays31XXICentury() {
        assertValid("02213100000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays31XXICentury() {
        assertInvalid("02213200000");
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays30XXICentury() {
        assertValid("02243000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays30XXICentury() {
        assertInvalid("02243100000");
    }

    @Test
    void testIsValidPeselCorrectPeselMonthValueXXICentury() {
        assertValid("02313000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselMonthValueXXICentury() {
        assertInvalid("02203000000");
    }

    @Test
    void testIsValidPeselCorrectPeselDayValueXXICentury() {
        assertValid("02253000000");
    }

    @Test
    void testIsValidPeselIncorrectPeselDayValueXXICentury() {
        assertInvalid("02259000000");
    }
}