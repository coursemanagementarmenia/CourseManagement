package am.mainserver.aear.model.tutorModel;

import am.mainserver.aear.model.userModel.User;

public class Tutor {
    private Long id;
    private String firstName;
    private String lastname;
    private String titel;
    private String email;
    private String description;/*it will be changed with Text or BLOB*/
    private String photoPath;
    User user;
}
