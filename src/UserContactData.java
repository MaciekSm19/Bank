/**
 * <pre> Class <code>UserContactData</code> stores user's contact data. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */

public class UserContactData {
    /**
     * <pre> Stores user's phone number </pre>
     */
    private String phoneNumber;

    /**
     * <pre> Stores user's e-mail address </pre>
     */
    private String email;

    /**
     * @see <code>Address</code>
     */
    private final Address address;

    /**
     *
     * @param phoneNumber   user's phone number
     * @param email         user's email
     * @param address       user's address
     */
    UserContactData(String phoneNumber, String email, Address address) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }
}
