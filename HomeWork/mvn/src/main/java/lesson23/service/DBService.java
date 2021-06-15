package lesson23.service;

import lesson23.service.dto.Student;
import lesson23.utils.DBUtils;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static lesson16.utils.ScannerController.scanCorrectIntValue;
import static lesson16.utils.ScannerController.scanLine;

/**
 * Class DBService
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 15.06.2021
 *
 * Main service for database connector.
 *
 * Allows to add, delete or get students from database.
 */
public class DBService {
    private final static String QUERIES_LIST = """
            1. Add new student.
            2. Delete student by id.
            3. Print current students.
            4. Print all students.
            5. Print student by full name.
            6. Print student by id.
            
            0. Exit
            """;

    public void run(String URL, String USER, String PASS) throws ClassNotFoundException, SQLException {
        if(URL == null || USER == null || PASS == null) {
            System.out.println("DBService wrong arguments.");
            return;
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();

        while(true) {
            System.out.println(QUERIES_LIST);
            switch (scanCorrectIntValue(0, 6, "Select your query:")) {
                case 1 -> addStudent(statement);
                case 2 -> deleteStudent(statement);
                case 3 -> printCurrentStudents(statement);
                case 4 -> printAllStudents(statement);
                case 5 -> printStudentByFullName(statement);
                case 6 -> printStudentById(statement);
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Wrong query!");
            }
            System.out.println("-----------------------------------------");
        }
    }

    /* Add new student to database. */
    private void addStudent(Statement statement) throws SQLException {
        int totalGroups = DBUtils.getGroupsCount(statement);

        String name = scanLine(50, "Enter student's full name:");
        int group = scanCorrectIntValue(1, totalGroups, "Enter student's group id:");
        int admYear = scanCorrectIntValue(1970, 2100, "Enter student's admission year:");
        System.out.println("Student added:" + DBUtils.addStudent(statement, new Student(name, group, admYear)));
    }

    /* Delete student from database. */
    private void deleteStudent(Statement statement) throws SQLException {
        int totalStudents = DBUtils.getStudentsCount(statement);

        int id = scanCorrectIntValue(1, totalStudents, "Enter student's id to delete:");
        System.out.println("Student deleted:" + DBUtils.deleteStudent(statement, id));
    }

    /* Print current students from database. */
    private void printCurrentStudents(Statement statement) throws SQLException {
        List<Student> list = DBUtils.getCurrentStudents(statement);
        for(Student s : list ) {
            System.out.println(s);
        }
        System.out.println("Current students:" + list.size());
    }

    /* Print all students from database. */
    private void printAllStudents(Statement statement) throws SQLException {
        List<Student> list = DBUtils.getAllStudents(statement);
        for(Student s : list ) {
            System.out.println(s);
        }
        System.out.println("Total students:" + list.size());
    }

    /* Print student from database by full name. */
    private void printStudentByFullName(Statement statement) throws SQLException {
        String name = scanLine(50, "Enter student's full name:");
        printStudentData(DBUtils.getStudent(statement, name));
    }

    /* Print student from database by id. */
    private static void printStudentById(Statement statement) throws SQLException {
        int totalStudents = DBUtils.getStudentsCount(statement);
        int id = scanCorrectIntValue(1, totalStudents, "Enter student's id:");
        printStudentData(DBUtils.getStudent(statement, id));
    }

    /* Internal method to print student data if exists. */
    private static void printStudentData(Student st) {
        Optional<Student> student = Optional.ofNullable(st);
        if(student.isPresent()) {
            if (!student.get().isDeleted()) {
                System.out.println("Found: " + student.get());
            } else {
                System.out.println("Student deleted.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}
