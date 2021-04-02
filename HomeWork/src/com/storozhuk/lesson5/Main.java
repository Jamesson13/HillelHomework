package com.storozhuk.lesson5;

/*
 * Вывести:
 * a) список студентов заданного факультета; - Факульет
 * b) списки студентов для каждого факультета и курса; - Факультет, Группа
 * c) список студентов, родившихся после заданного года; - Год рождения
 * d) список учебной группы. - Группа
 */

public class Main {
    public static void main(String[] args) {
        University polytech = new University("ОНПУ");

        polytech.addStudent(new Student("Петров", "Пётр",
                "Петрович", 2001, "Одесса", "(012)1234567",
                "ИИБРТ", 2, "РЕ-201"));
        polytech.addStudent(new Student("Иванов", "Иван",
                "Иванович", 1998, "Херсон", "(012)2345678",
                "ИИБРТ", 2, "РЕ-201"));
        polytech.addStudent(new Student("Гений", "Геннадий",
                "Генадъевич", 1997, "Запорожье", "(012)3456789",
                "ИИБРТ", 3, "РЕ-202"));
        polytech.addStudent(new Student("Михайлов", "Михаил",
                "Михайлович", 2002, "Николаев", "(012)4567890",
                "ИКС", 1, "КА-211"));
        polytech.addStudent(new Student("Андрейченко", "Андрей",
                "Андреевич", 1999, "Днепропетровск", "(012)5678901",
                "ИКС", 3, "КА-191"));
        polytech.addStudent(new Student("Александров", "Александр",
                "Александрович", 2001, "Кировоград", "(012)6789012",
                "ИКС", 2, "КА-201"));
        polytech.addStudent(new Student("Владимиров", "Владимир",
                "Владимирович", 2000, "Винница", "(012)7890123",
                "ИИИР", 2, "ИР-201"));
        polytech.addStudent(new Student("Викторов", "Виктор",
                "Викторович", 1996, "Полтава", "(012)8901234",
                "ИИИР", 4, "ИР-181"));
        polytech.addStudent(new Student("Юрченко", "Юрий",
                "Юрьевич", 1999, "Киев", "(012)9012345",
                "ИИИР", 2, "ИР-201"));

        System.out.println("\nStudents list:");
        polytech.printFullStudentsList();
        System.out.println("\nStudents from ИКС:");
        polytech.printStudentsFromFaculty("ИКС");
        System.out.println("\nStudents from 2 course of ИИБРТ:");
        polytech.printStudentsFromFacultyCourse("ИИБРТ", 2);
        System.out.println("\nStudents with birth after 1999:");
        polytech.printStudentsIfYounger(1999);
        System.out.println("\nStudents from РЕ-201:");
        polytech.printStudentsFromGroup("РЕ-201");
    }
}