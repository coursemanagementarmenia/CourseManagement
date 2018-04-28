package am.mainserver.aear.dao;

import am.mainserver.aear.domain.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {

    private PreparedStatement statement = null;

    public void saveStudent(Student student) throws SQLException {
        //TODO validation does current student exists in db already or not?
        //if(findByLogin())
        statement = DbAdapter.getInstance().getConnection().prepareStatement(
                "INSERT INTO students " +
                        "(firstName, lastName, age, email, phoneNumber)" +
                        " VALUE (?, ?, ?, ?, ?) "
        );

        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getLastName());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getPhoneNumber());

        statement.executeUpdate();
    }

    /*This method was created to avoid repetitive code*/
    private void extractAllStudents(ResultSet result, List<Student> list) throws SQLException {
        Student student;
        while (result.next()) {

            student = new Student();
            student.setId(result.getLong("id"));
            student.setFirstName(result.getString(2));
            student.setLastName(result.getString(3));
            student.setAge(result.getInt(4));
            student.setEmail(result.getString(5));
            student.setPhoneNumber(result.getString(6));
            list.add(student);
        }
    }

    public List<Student> findAll() throws SQLException {
        statement = DbAdapter.getInstance().getConnection().prepareStatement("SELECT * FROM students");
        ResultSet result = statement.executeQuery();
        List<Student> list = new ArrayList<Student>();
        Student student = null;
        extractAllStudents(result, list);
        return list;
    }

    // im jogelov karelia findStudent mi hat method unenal u overload anel, ay senc...

    public Student findStudent(Student student) throws SQLException {
        // todo: use all available "find" algorithms, to find a student, while having minimal information about him (email, f/l name, etc...)
        return new Student();
    }

    public Student findStudent(String email) throws SQLException {
        statement = DbAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM students WHERE email = ?"
        );
        statement.setString(1, email);

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

    public List<Student> findStudents(String firstName, String lastName) throws SQLException, IllegalArgumentException {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException();
        }
        statement = DbAdapter.getInstance().getConnection().prepareStatement(
                "SELECT * FROM students WHERE firstName = ? AND lastName = ?"
        );
        statement.setString(1, firstName);
        statement.setString(2, lastName);

        ResultSet result = statement.executeQuery();
        List<Student> list = new ArrayList<Student>();
        Student student = null;
        extractAllStudents(result, list);

        return list;
    }

    public void removeStudent(String email) throws SQLException {

        statement = DbAdapter.getInstance().getConnection().prepareStatement(
                "DELETE FROM students WHERE email = ?"
        );
        statement.setString(1, email);
        statement.executeUpdate();
    }
}