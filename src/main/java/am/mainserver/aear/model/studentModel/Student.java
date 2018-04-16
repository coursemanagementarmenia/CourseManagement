package am.mainserver.aear.model.studentModel;

import am.mainserver.aear.model.courseModel.Course;
import am.mainserver.aear.model.userModel.User;

import java.util.List;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phoneNumber;
    private List<Double> scores;
    private List<Course> courseList;
    private User user;
}
