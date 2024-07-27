import java.util.HashMap;
import java.util.Map;

public class User {
    private final UserPersonalData userPersonalData;
    private final UserContact userContactData;
    private final Credentials userLoginData;
    static Map<String, String> userLoginAndPassword = new HashMap<>();

    public User(UserPersonalData userPersonalData, UserContact userContactData, Credentials userLoginData) {
        this.userPersonalData = userPersonalData;
        this.userContactData = userContactData;
        this.userLoginData = userLoginData;
        userLoginAndPassword.put(userLoginData.getLogin(), userLoginData.getPassword());
    }

    public Credentials getUserLoginData() {
        return userLoginData;
    }

    public UserPersonalData getUserPersonalData() {
        return userPersonalData;
    }

    public UserContact getUserContactData() {
        return userContactData;
    }
}

