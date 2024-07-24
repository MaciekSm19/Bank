/**
 * <pre> Class <code>UserLoginData</code> stores user's login data. </pre>
 *
 * @author macieksm19
 * @version 1.0
 * @since 2024-07-23
 */

public class UserLoginData {
    /**
     * <pre> Stores user's login </pre>
     */
    private String login;

    /**
     * <pre> Stores user's password </pre>
     */
    private String password;

    /**
     *
     * @param login     user's login
     * @param password  user's password
     */
    UserLoginData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
