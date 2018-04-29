package am.mainserver.aear;

import am.mainserver.aear.dao.CourseDAO;
import am.mainserver.aear.dao.StudentCoursesDAO;
import am.mainserver.aear.dao.StudentDAO;
import am.mainserver.aear.domain.Course;
import am.mainserver.aear.domain.Student;

import java.sql.SQLException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        Course course = new Course();
        course.setName("C#");
        course.setDescription("C#, .NET Framework");
        course.setDuration(120);
        course.setPrice((double)30000);
        new CourseDAO().addCourse(course);
    }
}
