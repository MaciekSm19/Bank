/**
 * <pre> Class <code>Address</code> stores user's address data. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */

public class Address {
    /**
     * <pre> Stores user's city </pre>
     */
    private String city;

    /**
     * <pre> Stores user's street </pre>
     */
    private String street;

    /**
     * <pre> Stores user's number of house </pre>
     */
    private String houseNumber;

    /**
     * <pre> Stores user's postal code </pre>
     */
    private String postalCode;

    /**
     * <pre>Sets user's <code>city</code>, <code>street</code>, <code>houseNumber</code> and <code>postalCode</code> to variables</pre>
     *
     * @param city          @see <code>Address#city</code>
     * @param street        @see <code>Address#street</code>
     * @param houseNumber   @see <code>Address#houseNumber</code>
     * @param postalCode    @see <code>Address#postalCode</code>
     */
    public Address(String city, String street, String houseNumber, String postalCode) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}

