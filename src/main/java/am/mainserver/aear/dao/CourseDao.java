package am.mainserver.aear.dao;

import am.mainserver.aear.domain.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDao {

    private PreparedStatement statement = null;

    public void addCourse(Course course) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement("INSERT INTO courses " +
                "(name, duration, description, price) VALUE (?, ?, ?, ?)");

        statement.setString(1, course.getName());
        statement.setInt(2, course.getDuration());
        statement.setString(3, course.getDescription());
        statement.setDouble(4, course.getPrice());

        statement.executeUpdate();

    }


    public Course findByName(String name) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT * FROM courses WHERE name= ?");

        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Course course = new Course();

        course.setId(resultSet.getLong(1));
        course.setName(resultSet.getString(2));
        course.setDuration(resultSet.getInt(3));
        course.setDescription(resultSet.getString(4));
        course.setPrice(resultSet.getDouble(5));

        return course;
    }

    public Long findCourseId(Course course) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT id FROM courses WHERE name = ?");

        statement.setString(1, course.getName());

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        return resultSet.getLong(1);
    }

    public Course findById(Long id) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT * FROM courses WHERE id = ?");

        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Course course = new Course();

        course.setId(resultSet.getLong(1));
        course.setName(resultSet.getString(2));
        course.setDuration(resultSet.getInt(3));
        course.setDescription(resultSet.getString(4));
        course.setPrice(resultSet.getDouble(5));

        return course;
    }

    public void changeDescription(String description, Course course) throws SQLException {

        if (description == null || course == null) {
            throw new IllegalArgumentException();
        }

        Long a = findCourseId(course);

        statement = DbAdapter.getInstance().getConnection().prepareStatement
                (" UPDATE courses SET description = ? WHERE id = ?");

        statement.setString(1, description);
        statement.setLong(2, a);

        statement.executeUpdate();


    }

}
