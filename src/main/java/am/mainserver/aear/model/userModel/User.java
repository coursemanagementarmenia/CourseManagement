package am.mainserver.aear.model.userModel;

public class User {
    enum Role{
        ROLE_S,ROLE_T,ROLE_ADMIN;
    }
    
    private Long id;
    private Long student_id;
    private Long tutor_id;
    private String login;
    private String secureCode;
    private Role role;


    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }
}
