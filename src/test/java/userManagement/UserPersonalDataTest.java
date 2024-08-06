package userManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserPersonalDataTest {
    private UserPersonalData userPersonalData;
    private boolean isValid;

    @Test
    void testIsValidPeselCorrectPeselXXCentury() {
        userPersonalData = new UserPersonalData();

        userPersonalData.peselNumber = "50123100000";
        isValid = userPersonalData.isValidPesel();
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselLengthXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "52022900000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselLengthXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "520229000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselLeapYearXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "52022900000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselNotLeapYearXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50022900000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays31XXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50123100000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays31XXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "500123200000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays30XXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50043000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays30XXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50043100000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselMonthValueXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50043000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselMonthValueXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50000100000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselDayValueXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50041200000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselDayValueXXCentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "50040000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }


    @Test
    void testIsValidPeselCorrectPeselXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02243000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselLengthXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02243000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselLengthXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02243000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselLeapYearXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "04222900000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselNotLeapYearXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02222900000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays31XXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02213100000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays31XXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02213200000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselMaximumDays30XXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02243000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselMaximumDays30XXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02243100000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselMonthValueXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02313000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselMonthValueXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02203000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }

    @Test
    void testIsValidPeselCorrectPeselDayValueXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02253000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertTrue(isValid);
    }

    @Test
    void testIsValidPeselIncorrectPeselDayValueXXICentury() {
        //Given
        userPersonalData = new UserPersonalData();

        //When
        userPersonalData.peselNumber = "02259000000";
        isValid = userPersonalData.isValidPesel();

        //Then
        Assertions.assertFalse(isValid);
    }
}