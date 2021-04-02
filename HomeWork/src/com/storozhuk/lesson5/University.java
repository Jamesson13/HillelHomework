package com.storozhuk.lesson5;

/**
 * Class University
 *
 * Creates object University with array of Student objects.
 * By default, array size is zero and increased with every new student.
 */
public class University {
    private String universityName;
    private Integer studentsCount = 0;
    private Student[] studentsList = new Student[studentsCount];

    public University() {
    }

    public University(String universityName) {
        this.universityName = universityName;
    }

    /* Getters and Setters */
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    /* Add new Student to array */
    public void addStudent(Student st) {
        // create new temporary array and copy all students data
        Student[] tmp = new Student[++studentsCount];
        for(int i = 0; i < this.studentsList.length; i++) {
            tmp[i] = this.studentsList[i];
        }

        // add new student
        tmp[studentsCount-1] = st;
        this.studentsList = tmp;
    }

    /* Print full students list */
    public void printFullStudentsList() {
        for(Student s : this.studentsList) {
            System.out.println(s.toString());
        }
    }

    /* Print students from facultyName */
    public void printStudentsFromFaculty(String facultyName) {
        for(Student s : this.studentsList) {
            if(s.getFaculty().equals(facultyName)) {
                System.out.println(s.toString());
            }
        }
    }

    /* Print students from facultyName and course */
    public void printStudentsFromFacultyCourse(String facultyName, Integer course) {
        for(Student s : this.studentsList) {
            if(s.getFaculty().equals(facultyName) && s.getCourse().equals(course)) {
                System.out.println(s.toString());
            }
        }
    }

    /* Print students with year of birth greater than yearOfBirth */
    public void printStudentsIfYounger(Integer yearOfBirth) {
        for(Student s : this.studentsList) {
            if(s.getYearOfBirth() > yearOfBirth) {
                System.out.println(s.toString());
            }
        }
    }

    /* Print students from groupName */
    public void printStudentsFromGroup(String groupName) {
        for(Student s : this.studentsList) {
            if(s.getGroup().equals(groupName)) {
                System.out.println(s.toString());
            }
        }
    }
}
