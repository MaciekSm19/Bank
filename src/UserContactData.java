public class UserContactData {
    private String phoneNumber;
    private String email;
    private final Adress adress;

    UserContactData(String phoneNumber, String email, Adress adress) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAdress() {
        return adress;
    }
}
