import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class OperacjeNaUzytkowniku {
    private Adres adres;
    private Uzytkownik uzytkownik;
    private ArrayList<Uzytkownik> uzytkownicy;
    private Scanner scanner;

    OperacjeNaUzytkowniku() {
        uzytkownicy = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    void utworzUzytkownika() {
        System.out.println("Witaj w kreatorze uzytkownika. Musisz podac niezbedne dane, aby zarejestrowac sie w aplikacji baku.\n");
        System.out.print("Imie: ");
        String imie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String nazwisko = scanner.nextLine();
        System.out.print("Nazwisko panienskie matki: ");
        String nazwiskoPanienskieMatki = scanner.nextLine();
        System.out.print("Data urodzenia (RRRR-MM-DD): ");
        String dataUrodzenia = scanner.nextLine();
        System.out.print("PESEL: ");
        String pesel = scanner.nextLine();
        System.out.print("Numer telefonu: ");
        String numerTelefonu = scanner.nextLine();
        System.out.print("Adres e-mail: ");
        String email = scanner.nextLine();
        adres = utworzAdres();
        System.out.print("\nLogin: ");
        String login = scanner.nextLine();
        System.out.print("Haslo: ");
        String haslo = scanner.nextLine();

        uzytkownik = new Uzytkownik(imie, nazwisko, nazwiskoPanienskieMatki, LocalDate.parse(dataUrodzenia), pesel, numerTelefonu, email, adres, login, haslo);

        dodajUzytkownika(uzytkownik);

        System.out.println("Pomyslnie utworzono uzytkownika i dodano do bazy danych!");
    }

    private Adres utworzAdres() {
        System.out.print("\nMiejscowosc: ");
        String miejscowosc = scanner.nextLine();
        System.out.print("Ulica: ");
        String ulica = scanner.nextLine();
        System.out.print("Numer domu: ");
        String nrDomu = scanner.nextLine();
        System.out.print("Kod pocztowy: ");
        String kodPocztowy = scanner.nextLine();

        return new Adres(miejscowosc, ulica, nrDomu, kodPocztowy);
    }

    private void dodajUzytkownika(Uzytkownik uzytkownik) {
        uzytkownicy.add(uzytkownik);
    }

    @Override
    public String toString() {
        return STR."OperacjeNaUzytkowniku{uzytkownik=\{uzytkownik}";
    }

}