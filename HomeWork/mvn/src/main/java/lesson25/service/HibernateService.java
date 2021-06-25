package lesson25.service;

import lesson25.entity.Students;
import lesson25.entity.StudyGroups;
import lesson25.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

import static lesson16.utils.ScannerController.*;

/**
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 25.06.2021
 *
 * Main service for database connector based on hibernate framework.
 *
 * Allows to add or get students from database.
 */
public class HibernateService {
    private final static String QUERIES_LIST = """
            1. Add new student.
            2. Print current students.
            3. Print student by full name.
            4. Print student by id.
            
            0. Save and Exit
            """;

    public void run() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        while(true) {
            System.out.println(QUERIES_LIST);
            switch (scanCorrectIntValue(0, 4, "Select your query:")) {
                case 1 -> addStudent(session);
                case 2 -> printCurrentStudents(session);
                case 3 -> printStudentByFullName(session);
                case 4 -> printStudentById(session);
                case 0 -> {
                    System.out.println("Bye!");
                    session.getTransaction().commit();
                    return;
                }
                default -> System.out.println("Wrong query!");
            }
            System.out.println("-----------------------------------------");
        }
    }

    /* Add new student to database. */
    private void addStudent(Session session) {
        String name = scanLine(50, "Enter student's full name");
        int group = scanIntValue("Enter student's group id");
        // check studyGroup with such id exists
        StudyGroups sg = (StudyGroups) session.createQuery("from StudyGroups where Id = " + group).uniqueResult();
        if(sg == null) {
            System.out.println("Group with such id doesn't exists.");
            return;
        }
        int admYear = scanCorrectIntValue(1970, 2100, "Enter student's admission year");

        session.save(new Students().setFullName(name).setGroup(sg).setAdmYear(admYear));
        System.out.println("Student added!");
    }

    /* Print current students from database. */
    private void printCurrentStudents(Session session) {
        List<Students> list = session.createQuery("From Students where isDeleted=false").list();
        if(list.isEmpty()) {
            System.out.println("Students list is empty!");
            return;
        }

        for(Students s : list) {
            System.out.println(s);
        }
        System.out.println("Students in list: " + list.size());
    }

    /* Print student from database by full name. */
    private void printStudentByFullName(Session session) {
        String name = scanLine(50, "Enter student's full name");
        List<Students> list = session.createQuery("From Students where fullName = '" + name + "'").list();
        if(list.isEmpty()) {
            System.out.println("Student not found.");
            return;
        }

        for(Students s : list) {
            System.out.println(s);
        }
    }

    /* Print student from database by id. */
    private static void printStudentById(Session session) {
        int id = scanIntValue("Enter student's id");
        Students st = (Students) session.get(Students.class, id);
        if (st == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println(st);
    }
}
