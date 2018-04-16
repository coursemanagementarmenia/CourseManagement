package am.mainserver.aear.model.userModel;

public class User {
    enum Role{
        ROLE_S,ROLE_T,ROLE_ADMIN;
    }

    private String login;
    private String securCode;
    /*
    * in this constructor role input dose not initialized
    * role shut be concrete of user type*/

    public User(String login,String password,Role role){
        this.login = login;
        this.securCode = password;

    }
}
