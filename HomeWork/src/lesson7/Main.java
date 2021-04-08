package lesson7;
/*
 * Реализовать простую коллекцию для String на базе массива.
 *
 * добавить следующие методы для работы с коллекцией:
 * добавлять (add), (по индеку или значению)
 * удалять(delete), (по индексу или значению)
 * доставать по индексу (get),
 */

import lesson7.utils.StringCollection;

public class Main {
    public static void main(String[] args) {
        StringCollection sc = new StringCollection(4);
        System.out.println("\nEmpty collection (base size = 4):");
        System.out.println("Elements=" + sc.getSize() + " | Capacity=" + sc.getCapacity());
        System.out.println(sc.toString());

        System.out.println("\nAdding 7 strings: add, add, add[0], add[5], add[2], add[1], add[1]");
        System.out.println(sc.add("string0") + "|" + sc.add("string1") + "|" + sc.add("string2", 0) + "|"
                + sc.add("string3", 5) + "|" + sc.add("string4", 2) + "|"
                + sc.add("string5", 1) + "|" + sc.add("string6", 1));
        System.out.println("Elements=" + sc.getSize() + " | Capacity=" + sc.getCapacity());
        System.out.println(sc.toString());

        System.out.println("\nRemoving 5 strings: del[2], del(string1), del[10], del(badstring), del[0]");
        System.out.println(sc.delete(2) + "|" + sc.delete("string1") + "|" + sc.delete(10) + "|"
                + sc.delete("badstring") + "|" + sc.delete(0));
        System.out.println("Elements=" + sc.getSize() + " | Capacity=" + sc.getCapacity());
        System.out.println(sc.toString());

        System.out.println("\nGetting 3 string: get[2], get[8], get[0]");
        System.out.println(sc.get(2));
        System.out.println(sc.get(8));
        System.out.println(sc.get(0));
    }
}
