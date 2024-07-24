import java.time.LocalDate;

/**
 * <pre> Class <code>UserPersonalData</code> stores user's personal data. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */
public class UserPersonalData {

    /**
     * <pre> Stores user's first name </pre>
     */
    private String firstName;

    /**
     * <pre> Stores user's last name </pre>
     */
    private String lastName;

    /**
     * <pre> Stores user's mother's maiden name </pre>
     */
    private final String mothersMaidenName;

    /**
     * <pre> Stores user's date of birth in format YYYY-MM-DD </pre>
     *
     * <pre>For example: 2000-01-01 </pre>
     */
    private LocalDate dateOfBirth;

    /**
     * <pre>Stores user's PESEL number (pl. Powszechny Elektroniczny System Ewidencji Ludności), which allows to set user's <code>dateOfBirth</code>. </pre>
     */
    private String peselNumber;

    /**
     * <pre>Sets user's <code>firstName</code>, <code>lastName</code>, <code>mothersMaidenName</code> to variables</pre>
     *
     * @param firstName             @see <code>UserPersonalData#firstName</code>
     * @param lastName              @see <code>UserPersonalData#lastName</code>
     * @param mothersMaidenName     @see <code>UserPersonalData#mothersMaidenName</code>
     */

    UserPersonalData(String firstName, String lastName, String mothersMaidenName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
    }

    /**
     * <pre>Validates PESEL number. </pre>
     *
     * <pre>Requirements: </pre>
     *     <ul>
     *         <li>
     *             Length of PESEL number must be 11 digits.
     *         </li>
     *         <li>
     *             The third digit must be from 0-3 number range.
     *         </li>
     *         <li>
     *             The fourth digit must be from 0-2 number range when the third digit equals 1 or 3. Else the fourth digit must be from 0-9 number range.
     *         </li>
     *         <li>
     *             The fifth digit must be from 0-3 number range.
     *         </li>
     *          <li>
     *              The sixth digit must be from 0-1 number range when the fifth digit equals 3. Else the sixth digit must be from 0-9 number range.
     *          </li>
     *     </ul>
     *
     * @return  <code>true</code> if PESEL number is valid or <code>false</code> is PESEL number is not valid
     */
    boolean isValidPesel() {
        int maxDayValue = 28;
        int year = Integer.parseInt(String.valueOf(peselNumber.charAt(0)) + peselNumber.charAt(1));
        int month = Integer.parseInt(String.valueOf(peselNumber.charAt(2)) + peselNumber.charAt(3));
        int day = Integer.parseInt(String.valueOf(peselNumber.charAt(4)) + peselNumber.charAt(5));

        if (month == 2 || month == 22) {
            if (year % 4 == 0)
                maxDayValue = 29;
            else
                maxDayValue = 28;
        }
        else if ((month <= 7 || (month <= 27 && month >= 21)) && month % 2 == 1)
            maxDayValue = 31;
        else if ((month <= 7 || (month <= 27 && month >= 21)) && month % 2 == 0)
            maxDayValue = 30;
        else if (((month >= 8  && month <= 12) || month >= 28) && month % 2 == 0)
            maxDayValue = 31;
        else if (((month >= 8  && month <= 12) || month >= 28) && month % 2 == 1)
            maxDayValue = 30;

        boolean isValidLength = peselNumber.length() == 11;
        boolean isValidMonth = Character.getNumericValue(peselNumber.charAt(2)) <= 3 && (((Character.getNumericValue(peselNumber.charAt(2)) == 0 || Character.getNumericValue(peselNumber.charAt(2)) == 1) && Character.getNumericValue(peselNumber.charAt(3)) <= 2) || (Character.getNumericValue(peselNumber.charAt(2)) >= 0 || Character.getNumericValue(peselNumber.charAt(3)) == 2));
        boolean isValidDay = (Character.getNumericValue(peselNumber.charAt(4)) <= 3 && ((Character.getNumericValue(peselNumber.charAt(4)) == 3) && (Character.getNumericValue(peselNumber.charAt(5)) == 0) || Character.getNumericValue(peselNumber.charAt(5)) == 1) || ((Character.getNumericValue(peselNumber.charAt(4)) <= 2) && Character.getNumericValue(peselNumber.charAt(5)) >= 0)) && day <= maxDayValue;

        if (!isValidLength) {
            System.out.println("Dlugosc numeru PESEL jest niepoprawna. Sprobuj jeszcze raz.");
            return false;
        }
        if (!isValidMonth) {
            System.out.println("3 lub 4 (zapis miesiaca urodzenia) cyfra numeru PESEL jest niepoprawna. Sprobuj jeszcze raz.");
            return false;
        }
        if (!isValidDay) {
            System.out.println("5 lub 6 (zapis dnia urodzenia) cyfra numeru PESEL jest niepoprawna. Sprobuj jeszcze raz.");
            return false;
        }
        return isValidLength && isValidMonth && isValidDay;
    }

    /**
     * <pre>Converts PESEL number to the date of birth of the user.</pre>
     *
     * <pre> The first and the second digit describe user's year of born.</pre>
     * <ul>
     * <li>For example the first digit = 9, the second digit = 5, year of birth = 1995</li>
     * </ul>
     * <pre> The third and the fourth digit describe user's month of born (if those digits are in number range 1 - 12 user was born in XX century, if those digits are in number range 21 - 32 user was born in XXI century) </pre>
     * For example:
     * <ul>
     *     <li>the third digit = 0 the fourth digit = 1, month of born = 01 - January (XX century)</li>
     *     <li>the third digit = 2 the fourth digit = 1, month of born = 01 - January (XXI century)</li>
     * </ul>
     *
     * <pre> The fifth digit and the sixth digit describes user's day of born </pre>
     * For example:
     * <ul>
     *     <li>the fifth digit = 1 the fourth digit = 0, month of born = 10</li>
     * </ul>
     *
     * <pre>Example of the PESEL number conversion:</pre>
     * <ol>
     *     <li>95011000000 -> year of born - 1995, month of born - 01 (January), day of born - 10 </li>
     *     <li>12211000000 -> year of born - 2012, month of born - 01 (January), day of born - 10 </li>
     * </ol>
     */
    void convertPeselToDateOfBirth() {
        String year = null;
        String month = null;

        if (Character.getNumericValue(peselNumber.charAt(2)) == 1 || Character.getNumericValue(peselNumber.charAt(2)) == 0) {
            year = "19" + peselNumber.charAt(0) + peselNumber.charAt(1);
            month = String.valueOf(peselNumber.charAt(2)) + peselNumber.charAt(3);
        } else if(Character.getNumericValue(peselNumber.charAt(2)) == 2 || Character.getNumericValue(peselNumber.charAt(2)) == 3) {
            year = "20" + Character.getNumericValue(peselNumber.charAt(0)) + Character.getNumericValue(peselNumber.charAt(1));
            month = String.valueOf(Integer.parseInt(String.valueOf(peselNumber.charAt(2)) + String.valueOf(peselNumber.charAt(3))) - 20);

        }

        if (Integer.parseInt(month) < 10)
            month = "0" + peselNumber.charAt(3);

        String day = String.valueOf(peselNumber.charAt(4)) + peselNumber.charAt(5);
        if (day != null && month != null && year != null) {
            dateOfBirth = LocalDate.parse(year + "-" + month + "-" + day);
            System.out.println("Twoja data urodzin: " + dateOfBirth);
        } else
            System.out.println("Wystapil blad w konwersji");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }
}
