package user;

public class UserContact {
    String phoneNumber;
    String email;
    private final Address address;

    UserContact(String phoneNumber, String email, Address address) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
