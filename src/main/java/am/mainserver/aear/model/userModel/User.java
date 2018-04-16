package am.mainserver.aear.model.userModel;

public class User {
    enum Role {
        ROLE_S, ROLE_T, ROLE_ADMIN;
    }

    private String login;
    private String secureCode;

    /*
    * in this constructor role input is not initialized
    * role should be concrete of user type
    */

    public User(String login, String password, Role role) {
        this.login = login;
        this.secureCode = password;

    }
}
