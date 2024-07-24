import java.util.HashMap;
import java.util.Map;

/**
 * <pre> Class <code>User</code> stores user's data. </pre>
 *
 *  @author macieksm19
 *  @version 1.0
 *  @since 2024-07-23
 */
public class User {
    /**
     * @see <code>UserPersonalData</code>
     */
    private final UserPersonalData userPersonalData;

    /**
     * @see <code>UserContactData</code>
     */
    private final UserContactData userContactData;

    /**
     * @see <code>UserLoginData</code>
     */
    private final UserLoginData userLoginData;

    /**
     * <pre> Stores user's login and password </pre>
     */
    static Map<String, String> userLoginAndPassword = new HashMap<>();

    /**
     *
     * @param userPersonalData  @see <code>UserPersonalData</code>
     * @param userContactData   @see <code>UserContactData</code>
     * @param userLoginData     @see <code>UserLoginData</code>
     */
    public User(UserPersonalData userPersonalData, UserContactData userContactData, UserLoginData userLoginData) {
        this.userPersonalData = userPersonalData;
        this.userContactData = userContactData;
        this.userLoginData = userLoginData;
        userLoginAndPassword.put(userLoginData.getLogin(), userLoginData.getPassword());
    }

    public UserLoginData getUserLoginData() {
        return userLoginData;
    }

    public UserPersonalData getUserPersonalData() {
        return userPersonalData;
    }

    public UserContactData getUserContactData() {
        return userContactData;
    }
}

