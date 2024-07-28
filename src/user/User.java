package user;

public record User(UserPersonalData userPersonalData, UserContact userContact, Credentials credentials) {
    public User(UserPersonalData userPersonalData, UserContact userContact, Credentials credentials) {
        this.userPersonalData = userPersonalData;
        this.userContact = userContact;
        this.credentials = credentials;
    }
}

