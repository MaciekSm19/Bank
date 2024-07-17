public class Adres {
    private String miejscowosc;
    private String ulica;
    private String nrDomu;
//    private String nrLokalu;
    private String kodPocztowy;

//    public Adres(String miejscowosc, String ulica, String nrDomu, String nrLokalu, String kodPocztowy) {
//        this.miejscowosc = miejscowosc;
//        this.ulica = ulica;
//        this.nrDomu = nrDomu;
////        this.nrLokalu = nrLokalu;
//        this.kodPocztowy = kodPocztowy;
//    }

    public Adres(String miejscowosc, String ulica, String nrDomu, String kodPocztowy) {
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public String toString() {
        return STR."Adres{miejscowosc='\{miejscowosc}\{'\''}, ulica='\{ulica}\{'\''}, nrDomu='\{nrDomu}\{'\''}, kodPocztowy='\{kodPocztowy}\{'\''}\{'}'}";

    }
}

