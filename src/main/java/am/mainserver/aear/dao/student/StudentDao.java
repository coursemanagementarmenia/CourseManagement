package am.mainserver.aear.dao.student;

import am.mainserver.aear.dao.DbAdapter;
import am.mainserver.aear.model.general.StudentCoursesScores;
import am.mainserver.aear.model.studentModel.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDao {

    private PreparedStatement statement = null;

    public void saveStudent(Student student) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement("INSERT INTO students " +
                "(firstName, lastName, age, email, phoneNumber)" +
                " VALUE (?, ?, ?, ?, ?) ");

        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getPhoneNumber());

        statement.executeUpdate();
    }

    public Student findByLogin(String email) throws SQLException{

        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT * FROM students WHERE " +
                "email = ?");

        statement.setString(1,email);

        ResultSet result = statement.executeQuery();

        result.next();

        Student student = new Student();

        student.setId(result.getLong("id"));
        student.setFirstName(result.getString(2));
        student.setLastName(result.getString(3));
        student.setAge(result.getInt(4));
        student.setEmail(result.getString(5));
        student.setPhoneNumber(result.getString(6));

        return student;

    }

    public List<Student> findAll() throws SQLException{

        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT * FROM students");

        ResultSet result = statement.executeQuery();

        List<Student> list = new ArrayList<Student>();

        Student student = null;

        while (result.next()){

            student = new Student();
            student.setId(result.getLong("id"));
            student.setFirstName(result.getString(2));
            student.setLastName(result.getString(3));
            student.setAge(result.getInt(4));
            student.setEmail(result.getString(5));
            student.setPhoneNumber(result.getString(6));
            list.add(student);
        }

        return list;
    }

    public List<Student> findByFullName(String firstName, String lastName) throws SQLException{

        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException();
        }

        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT * FROM students " +
                "WHERE firstName = ? AND lastName = ?");

        statement.setString(1, firstName);
        statement.setString(2, lastName);

        ResultSet result = statement.executeQuery();

        List<Student> list = new ArrayList<Student>();

        Student student = null;

        while (result.next()){

            student = new Student();
            student.setId(result.getLong("id"));
            student.setFirstName(result.getString(2));
            student.setLastName(result.getString(3));
            student.setAge(result.getInt(4));
            student.setEmail(result.getString(5));
            student.setPhoneNumber(result.getString(6));
            list.add(student);
        }

        return list;
    }

    public Long findStudentId(String emil) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT id FROM students " +
                "WHERE email = ?");

        statement.setString(1,emil);

        ResultSet result = statement.executeQuery();

        result.next();

        return result.getLong(1);
    }

    public void removeStudent(String email) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement("DELETE FROM students " +
                "WHERE email = ?");

        statement.setString(1, email);

        statement.executeUpdate();
    }



}