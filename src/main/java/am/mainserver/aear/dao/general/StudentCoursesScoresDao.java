package am.mainserver.aear.dao.general;

import am.mainserver.aear.dao.DbAdapter;
import am.mainserver.aear.dao.course.CourseDao;
import am.mainserver.aear.model.courseModel.Course;
import am.mainserver.aear.model.studentModel.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StudentCoursesScoresDao {

    private PreparedStatement preparedStatement = null;

    public void addCourse(Student student, Course course) throws SQLException {

        preparedStatement = DbAdapter.getInstance().getConnection().prepareStatement("INSERT INTO student_courses_scores" +
                "(student_id,course_id) VALUE (?, ?)");

        preparedStatement.setLong(1, student.getId());
        preparedStatement.setLong(2, course.getId());

        preparedStatement.executeUpdate();
    }

    public void addSccre(Student student, Course course, Double score) throws SQLException {

        preparedStatement = DbAdapter.getInstance().getConnection().prepareStatement
                ("UPDATE student_courses_scores SET score = ? WHERE student_id = ? AND  course_id  = ?");

        preparedStatement.setDouble(1, score);
        preparedStatement.setLong(2, student.getId());
        preparedStatement.setLong(3, course.getId());

        preparedStatement.executeUpdate();
    }

    public Map<String,Double> addCourseAndScore (Student student) throws SQLException{

        preparedStatement = DbAdapter.getInstance().getConnection().prepareStatement
                ("SELECT * FROM student_courses_scores WHERE student_id = ?");

        preparedStatement.setLong(1, student.getId());

        ResultSet resultSet = preparedStatement.executeQuery();

        Map<String,Double> map = new HashMap<String, Double>();

        while (resultSet.next()){

            map.put(new CourseDao().findById(resultSet.getLong(4)).getName(),resultSet.getDouble(2));
        }

        return map;
    }
}
