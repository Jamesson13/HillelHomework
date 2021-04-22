package com.storozhuk.lesson11;

import com.storozhuk.lesson11.records.User;

/*
 * Java 14 Preview
 */
public class Java14 {
    public static void main(String[] args) {
        /* Record example */
        User u = new User("John", 30);
        System.out.println(u.name() + ", " + u.age());

        /* Text block example */
        String ex = """
                Text
                Block
                Example
                """;
        System.out.println(ex);

        /* Switch example */
        var something = switch(4) {
            case 1, 2, 3 -> "from 1 to 3";
            case 4, 5 -> "4 or 5";
            default -> "not 1 to 5";
        };
        System.out.println("Something is " + something);

        /* instanceof example */
        Object obj = 57;
        if (obj instanceof Integer) {
            System.out.println("Object is integer with value " + (Integer)obj);
        }
    }
}
