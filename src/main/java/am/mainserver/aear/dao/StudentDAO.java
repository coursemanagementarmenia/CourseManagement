package am.mainserver.aear.dao;

import am.mainserver.aear.domain.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
    private PreparedStatement statement = null;

    public void addStudent(Student student) throws SQLException {
        if (getStudent(student.getEmail()) != null) {
            System.out.println("Student with that email already exists");
            return;
        }
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "INSERT INTO Student" +
                        "(firstName, lastName, age, email, phoneNumber)" +
                        " VALUES (?, ?, ?, ?, ?) "
        );
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getPhoneNumber());
        statement.executeUpdate();
    }

    public Student getStudent(long studentID) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM Student " +
                        "WHERE id = ?"
        );
        statement.setLong(1, studentID);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        if (resultSet.getRow() == 0) {
            return null;
        }
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setFirstName(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        student.setPhoneNumber(resultSet.getString("phoneNumber"));
        return student;
    }

    public Student getStudent(String email) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM Student " +
                        "WHERE email = ?"
        );
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        if (resultSet.getRow() == 0) {
            return null;
        }
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setFirstName(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        student.setPhoneNumber(resultSet.getString("phoneNumber"));
        return student;
    }

    public List<Student> getAllStudents() throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM Student"
        );
        ResultSet result = statement.executeQuery();
        List<Student> list = new ArrayList<Student>();
        extractAllStudents(result, list);
        return list;
    }

    /*This method was created to avoid repetitive code*/
    private void extractAllStudents(ResultSet result, List<Student> list) throws SQLException {
        Student student = new Student();
        while (result.next()) {
            student.setId(result.getLong("id"));
            student.setFirstName(result.getString("firstName"));
            student.setLastName(result.getString("lastName"));
            student.setEmail(result.getString("email"));
            student.setAge(result.getInt("age"));
            student.setPhoneNumber(result.getString("phoneNumber"));
            list.add(student);
        }
    }

    public List<Student> getStudents(String firstName, String lastName) throws SQLException {
        if (firstName == null || firstName.length() == 0 || lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException();
        }
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM Student " +
                        "WHERE firstName = ? AND lastName = ?"
        );
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        ResultSet result = statement.executeQuery();
        List<Student> list = new ArrayList<Student>();
        extractAllStudents(result, list);
        return list;
    }

    public void removeStudent(long studentID) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "DELETE FROM Student " +
                        "WHERE id = ?"
        );
        statement.setLong(1, studentID);
        statement.executeUpdate();
    }

    public void removeStudent(String email) throws SQLException {
        statement = DBAdapter.getInstance().getConnection().prepareStatement(
                "DELETE FROM Student " +
                        "WHERE email = ?"
        );
        statement.setString(1, email);
        statement.executeUpdate();
    }
}
