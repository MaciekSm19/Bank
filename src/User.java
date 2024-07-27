import java.util.HashMap;
import java.util.Map;

public record User(UserPersonalData userPersonalData, UserContact userContactData, Credentials userLoginData) {
    static Map<String, String> userLoginAndPassword = new HashMap<>();

    public User(UserPersonalData userPersonalData, UserContact userContactData, Credentials userLoginData) {
        this.userPersonalData = userPersonalData;
        this.userContactData = userContactData;
        this.userLoginData = userLoginData;
        userLoginAndPassword.put(userLoginData.getLogin(), userLoginData.getPassword());
    }
}

