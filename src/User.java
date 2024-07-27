import java.util.HashMap;
import java.util.Map;

public class User {
    private final UserPersonalData userPersonalData;
    private final UserContactData userContactData;
    private final UserLoginData userLoginData;
    static Map<String, String> userLoginAndPassword = new HashMap<>(); //naprawić

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

