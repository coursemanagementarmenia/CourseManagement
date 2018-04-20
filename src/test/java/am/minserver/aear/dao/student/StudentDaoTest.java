package am.minserver.aear.dao.student;

import am.mainserver.aear.dao.StudentDao;
import am.mainserver.aear.domain.Student;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StudentDaoTest {

    static Student Gago = new Student();

    @BeforeClass
    public static void init () {

        Gago.setPhoneNumber("055555555");
        Gago.setFirstName("Gago");
        Gago.setLastName("Gagikyan");
        Gago.setAge(44);
        Gago.setEmail("Gag@mil.ru");
    }

    @Before
    @Test
    public void saveStudentTest () {

        try {
            new StudentDao().saveStudent(Gago);
        } catch (SQLException e) {
            fail("Any SQL Exeption in saveStudent method");
        }
    }

    @Test
    public void findByLoginTest(){

        Student student = null;

        try {
            student = new StudentDao().findByLogin("Gag@mil.ru");
        } catch (SQLException e) {
            fail("Any SQL Exeption in findByLoginTest method");
        }

        assertEquals(student.getFirstName(), Gago.getFirstName());
    }

    @After
    @Test
    public void removeStudentTest (){

        try {
            new StudentDao().removeStudent("Gag@mil.ru");
        } catch (SQLException e) {
            fail("Any SQL Exeption in remove method");
        }
    }


}
