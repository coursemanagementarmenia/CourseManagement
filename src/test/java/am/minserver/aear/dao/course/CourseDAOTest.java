package am.minserver.aear.dao.course;

import am.mainserver.aear.dao.CourseDAO;
import am.mainserver.aear.domain.Course;
import org.junit.Test;

import java.sql.SQLException;

public class CourseDAOTest {
    static Course javaCourse = new Course();


    @Test
    public void initialization(){
        javaCourse.setDuration(88);
        javaCourse.setDescription("Its jata javaCourse");
        javaCourse.setPrice(50000.0);
        javaCourse.setName("JAVA");

        try {
            new CourseDAO().addCourse(javaCourse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
    @Test
    public void changeDescriptionTest(){

        try {
            new CourseDAO().changeDescription("It is an JAVA Course",javaCourse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}
