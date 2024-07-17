import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private String nazwiskoPanienskieMatki;
    private LocalDate dataUrodzenia;
    private String pesel;
    private String numerTelefonu;
    private String email;
    private Adres adresZamieszkania;
    private Map<String, String> uzytkownik = new HashMap<String, String>();

    public Uzytkownik(String imie, String nazwisko, String nazwiskoPanienskieMatki, LocalDate dataUrodzenia, String pesel, String numerTelefonu, String email, Adres adresZamieszkania, String login, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwiskoPanienskieMatki = nazwiskoPanienskieMatki;
        this.dataUrodzenia = dataUrodzenia;
        this.pesel = pesel;
        this.numerTelefonu = numerTelefonu;
        this.email = email;
        this.adresZamieszkania = adresZamieszkania;
        uzytkownik.put(login, haslo);
    }

    @Override
    public String toString() {
        return STR."Imie: \{imie}\nNazwisko: \{nazwisko}\nNazwisko panienskie matki: \{nazwiskoPanienskieMatki}\nData urodzenia: \{dataUrodzenia}\nPesel: \{pesel}\nNumer telefonu: \{numerTelefonu}\nE-mail: \{email}\nAdres zamieszkania: ";
    }
}

