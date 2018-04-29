package am.mainserver.aear.dao;

import am.mainserver.aear.domain.Course;
import am.mainserver.aear.domain.StudentCourses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;

public class StudentCoursesDAO {
    private PreparedStatement preparedStatement = null;

    public StudentCoursesDAO() {

    }

    public void addCourse(long studentID, long courseID, double mark) throws SQLException {
        if(getStudentCourses(studentID).containsKey(courseID)) {
            System.out.println("Course with that ID already exists");
            return;
        }
        preparedStatement = DBAdapter.getInstance().getConnection().prepareStatement(
                "INSERT INTO StudentCourses (studentID, courseID, mark)" +
                        "VALUES ( ?, ?, ?)"
        );
        preparedStatement.setLong(1, studentID);
        preparedStatement.setLong(2, courseID);
        preparedStatement.setDouble(3, mark);
        preparedStatement.executeUpdate();
    }

    public void addCourse(long studentID, long courseID) throws SQLException {
        addCourse(studentID, courseID, 0);
    }

    public Map<Long, Double> getStudentCourses(long studentID) throws SQLException {
        preparedStatement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM StudentCourses " +
                        "WHERE studentID = ?"
        );
        preparedStatement.setLong(1, studentID);
        ResultSet resultSet = preparedStatement.executeQuery();
        Map<Long, Double> marks = new HashMap<Long, Double>() {
            @Override
            public Set<Entry<Long, Double>> entrySet() {
                return null;
            }
        };
        while (resultSet.next()) {
            marks.put(resultSet.getLong("courseID"), resultSet.getDouble("mark"));
        }
        if (marks.size() == 0) {
            return null;
        }
        return marks;
    }
}
