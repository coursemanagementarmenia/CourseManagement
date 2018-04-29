package am.mainserver.aear.dao;

import am.mainserver.aear.domain.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {
    private PreparedStatement statement = null;

    public void addCourse(Course course) throws SQLException {
        if (exists(course.getName())) {
            System.out.println("Course with that name already exists");
            return;
        }
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "INSERT INTO Course (name, duration, description, price) " +
                        "VALUES (?, ?, ?, ?)"
        );
        statement.setString(1, course.getName());
        statement.setInt(2, course.getDuration());
        statement.setString(3, course.getDescription());
        statement.setDouble(4, course.getPrice());
        statement.executeUpdate();
    }

    public Course getCourse(long courseID) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM Course " +
                        "WHERE id = ?"
        );
        statement.setLong(1, courseID);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        if (resultSet.getRow() == 0) {
            return null;
        }
        Course course = new Course();
        course.setId(resultSet.getLong(1));
        course.setName(resultSet.getString(2));
        course.setDuration(resultSet.getInt(3));
        course.setDescription(resultSet.getString(4));
        course.setPrice(resultSet.getDouble(5));
        return course;
    }

    public Course getCourse(String courseName) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM Course " +
                        "WHERE name = ?"
        );
        statement.setString(1, courseName);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        if (resultSet.getRow() == 0) {
            return null;
        }
        Course course = new Course();
        course.setId(resultSet.getLong(1));
        course.setName(resultSet.getString(2));
        course.setDuration(resultSet.getInt(3));
        course.setDescription(resultSet.getString(4));
        course.setPrice(resultSet.getDouble(5));
        return course;
    }

    public long getCourseId(String courseName) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT id FROM Course " +
                        "WHERE name = ?"
        );
        statement.setString(1, courseName);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        if (resultSet.getRow() == 0) {
            return 0;
        }
        return resultSet.getLong(1);
    }

    /*  Created to avoid code repetition  */
    private void updateCourse(Course course) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "UPDATE Course SET " +
                        "name = ?, " +
                        "duration = ?, " +
                        "description = ?, " +
                        "price = ?" +
                        "WHERE id = ?"
        );
        statement.setString(1, course.getName());
        statement.setInt(2, course.getDuration());
        statement.setString(3, course.getDescription());
        statement.setDouble(4, course.getPrice());
        statement.setLong(5, course.getId());
        statement.executeUpdate();
    }

    public void updateDescription(long courseID, String description) throws SQLException {
        Course course = getCourse(courseID);
        course.setDescription(description);
        updateCourse(course);
    }

    public boolean exists(String courseName) throws SQLException {
        return getCourse(courseName) != null;
    }
}
