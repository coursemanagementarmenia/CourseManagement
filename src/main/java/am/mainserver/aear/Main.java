package am.mainserver.aear;

import am.mainserver.aear.dao.CourseDao;
import am.mainserver.aear.domain.Course;
import am.mainserver.aear.domain.Student;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
//        Student Gago = new Student();
//        Gago.setPhoneNumber("055555555");
//        Gago.setFirstName("Gago");
//        Gago.setLastName("Gagikyan");
//        Gago.setAge(44);
//        Gago.setEmail("Gag@mil.ru");
//
//        try {
//            new StudentDao().saveStudent(Gago);
//        } catch (SQLException e) {
//            e.printStackTrace();
////        }
//        Long g;
//        Student valod = null;
//        try {
//            System.out.println(valod = new StudentDao().findByLogin("Gag@mil.ru"));
//            System.out.println( g = new StudentDao().findStudentId("Gag@mail.ru"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Course course = null;
        Student student = null;

        try {
//            student = new StudentDao().findByLogin("EdgarAyvazyan996@gmail.com");
//            System.out.println(student);
//            student.setCourseAndScoresList(new StudentCoursesScoresDao().addCourseAndScore(student));
//            System.out.println(student);
            course = new CourseDao().findByName("Java");
            new CourseDao().changeDescription("Look up Java core and web development", course);
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        StudentCoursesScoresDao studentCoursesScoresDao = new StudentCoursesScoresDao();
//        try {
//            studentCoursesScoresDao.addScore(student,course,5.5);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try {
//            courseDao.addCourse(course);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//
//        try {
//            courseDao.changeDescription("hjhjkhhjkj",course);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        Student vardan = new Student();
//
//
//        vardan.setFirstName("Vardan");
//        vardan.setLastName("Manukyan");
//        vardan.setAge(22);
//        vardan.setEmail("Vard@gmail.com");
//        vardan.setPhoneNumber("055555588");
//
//
//        try {
//            new StudentDao().saveStudent(vardan);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//


    }
}
