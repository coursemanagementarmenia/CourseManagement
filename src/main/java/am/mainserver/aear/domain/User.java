package am.mainserver.aear.domain;

public class User {
    enum Role {
        ROLE_STUDENT, ROLE_TUTOR, ROLE_ADMIN;
    }

    private long id;
    private long student_id;
    private long tutor_id;
    private String login;
    private String secureCode;
    private Role role;


    public User() {

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
