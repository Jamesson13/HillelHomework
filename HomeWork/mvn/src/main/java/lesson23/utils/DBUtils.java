package lesson23.utils;

import lesson23.service.dto.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class DBUtils
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 15.06.2021
 *
 * Utils to work with Student database.
 * Contains methods to add, delete or change data in database.
 */
public class DBUtils {
    /* Add new student object to database. */
    public static boolean addStudent(Statement st, Student student) throws SQLException {
        String query = String.format(
                "INSERT INTO Student.Students (FullName, GroupId, AdmYear) " +
                "VALUES ('%s', %d, %d)", student.getFullName(), student.getGroupId(), student.getAdmYear());
        return st.executeUpdate(query) == 1;
    }

    /* Delete student with such id from database. (Sets 'IsDeleted' flag to true) */
    public static boolean deleteStudent(Statement st, int id) throws SQLException {
        String query = String.format(
                "UPDATE Student.Students " +
                "SET IsDeleted = true " +
                "WHERE Student.Students.Id = %d", id);
        return st.executeUpdate(query) == 1;
    }

    /* Get list of Student object from database. Deleted students is skipped. */
    public static List<Student> getCurrentStudents(Statement st) throws SQLException {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM Student.Students WHERE Student.Students.IsDeleted = false";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            list.add(getStudentFromResultSet(rs));
        }
        return list;
    }

    /* Get list of Student object from database. Deleted students included. */
    public static List<Student> getAllStudents(Statement st) throws SQLException {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM Student.Students";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            list.add(getStudentFromResultSet(rs));
        }
        return list;
    }

    /* Get FIRST Student object from database by fullName. */
    public static Student getStudent(Statement st, String fullName) throws SQLException {
        String query = String.format(
                "SELECT * FROM Student.Students " +
                "WHERE Student.Students.FullName = '%s'", fullName);
        ResultSet rs = st.executeQuery(query);
        return rs.next()?getStudentFromResultSet(rs):null;
    }

    /* Get Student object from database by id.  */
    public static Student getStudent(Statement st, int id) throws SQLException {
        String query = String.format(
                "SELECT * FROM Student.Students " +
                        "WHERE Student.Students.Id = %d", id);
        ResultSet rs = st.executeQuery(query);
        return rs.next()?getStudentFromResultSet(rs):null;
    }

    /* Get groups count from StudyGroups table. */
    public static int getGroupsCount(Statement st) throws SQLException {
        String query = "SELECT COUNT(*) AS totalRows FROM Student.StudyGroups";
        ResultSet rs = st.executeQuery(query);
        return rs.next()?rs.getInt("totalRows"):0;
    }

    /* Get students count from Student table. Deleted students are INCLUDED. */
    public static int getStudentsCount(Statement st) throws SQLException {
        String query = "SELECT COUNT(*) AS totalRows FROM Student.Students";
        ResultSet rs = st.executeQuery(query);
        return rs.next()?rs.getInt("totalRows"):0;
    }

    /* Private method which allow to create Student object from ResultSet data.  */
    private static Student getStudentFromResultSet(ResultSet rs) throws SQLException {
        int Id = rs.getInt("Id");
        String FullName = rs.getString("FullName");
        int GroupId = rs.getInt("GroupId");
        int AdmYear = rs.getInt("AdmYear");
        boolean IsDeleted = rs.getBoolean("IsDeleted");

        return new Student().setId(Id)
                .setFullName(FullName)
                .setGroupId(GroupId)
                .setAdmYear(AdmYear)
                .setDeleted(IsDeleted);
    }
}
