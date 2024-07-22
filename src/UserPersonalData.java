import java.time.LocalDate;

public class UserPersonalData {
    private String firstName;
    private String lastName;
    private final String mothersMaidenName;
    private LocalDate dateOfBirth;
    private String pesel;

    UserPersonalData(String firstName, String lastName, String mothersMaidenName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
    }

    boolean isValidPesel() {
        int maxDayValue = 28;
        int year = Integer.parseInt(String.valueOf(pesel.charAt(0)) + pesel.charAt(1));
        int month = Integer.parseInt(String.valueOf(pesel.charAt(2)) + pesel.charAt(3));
        int day = Integer.parseInt(String.valueOf(pesel.charAt(4)) + pesel.charAt(5));

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

        boolean isValidLength = pesel.length() == 11;
        boolean isValidMonth = Character.getNumericValue(pesel.charAt(2)) <= 3 && (((Character.getNumericValue(pesel.charAt(2)) == 0 || Character.getNumericValue(pesel.charAt(2)) == 1) && Character.getNumericValue(pesel.charAt(3)) <= 2) || (Character.getNumericValue(pesel.charAt(2)) >= 0 || Character.getNumericValue(pesel.charAt(3)) == 2));
        boolean isValidDay = (Character.getNumericValue(pesel.charAt(4)) <= 3 && ((Character.getNumericValue(pesel.charAt(4)) == 3) && (Character.getNumericValue(pesel.charAt(5)) == 0) || Character.getNumericValue(pesel.charAt(5)) == 1) || ((Character.getNumericValue(pesel.charAt(4)) <= 2) && Character.getNumericValue(pesel.charAt(5)) >= 0)) && day <= maxDayValue;

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

    void convertPeselToDateOfBirth() {
        String year = null;
        String month = null;

        if (Character.getNumericValue(pesel.charAt(2)) == 1 || Character.getNumericValue(pesel.charAt(2)) == 0) {
            year = "19" + pesel.charAt(0) + pesel.charAt(1);
            month = String.valueOf(pesel.charAt(2)) + pesel.charAt(3);
        } else if(Character.getNumericValue(pesel.charAt(2)) == 2 || Character.getNumericValue(pesel.charAt(2)) == 3) {
            year = "20" + Character.getNumericValue(pesel.charAt(0)) + Character.getNumericValue(pesel.charAt(1));
            month = String.valueOf(Integer.parseInt(String.valueOf(pesel.charAt(2)) + String.valueOf(pesel.charAt(3))) - 20);

        }

        if (Integer.parseInt(month) < 10)
            month = "0" + pesel.charAt(3);

        String day = String.valueOf(pesel.charAt(4)) + pesel.charAt(5);
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

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
