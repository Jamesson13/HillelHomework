package com.storozhuk.lesson8;

import com.storozhuk.lesson8.service.impl.StringCollection;

import java.util.LinkedList;
import java.util.List;

/*
 * Реализовать простую коллекцию для String на базе массива используя интерфейс
 */
public class Main {
    public static void main(String[] args) {

        LinkedList<String> a = new LinkedList<>();
        a.add("adf");
        a.clear();

        StringCollection sc1 = new StringCollection(2);
        StringCollection sc2 = new StringCollection(2);
        System.out.println("\nEmpty collections (base size = 2):");
        System.out.println("sc1: Elements=" + sc1.size() + " | Capacity=" + sc1.getCapacity());
        System.out.println("sc2: Elements=" + sc2.size() + " | Capacity=" + sc2.getCapacity());
        System.out.println("StringCollection sc1: " + sc1);
        System.out.println("StringCollection sc2: " + sc2);

        System.out.print("\nAdding 5 strings to sc1: ");
        System.out.println("add(q)=" + sc1.add("q")
                + " || add(w)=" + sc1.add("w")
                + " || add(e)=" + sc1.add("e")
                + " || add(3, r)=" + sc1.add(3, "r")
                + " || add(0, t)=" + sc1.add(0, "t"));
        System.out.println("sc1: Elements=" + sc1.size() + " | Capacity=" + sc1.getCapacity());
        System.out.println("StringCollection sc1: " + sc1);

        System.out.print("\nAdding 5 strings to sc2: ");
        System.out.println("add(0, q)=" + sc2.add(0, "q")
                + " || add(w)=" + sc2.add("w")
                + " || add(10, e)=" + sc2.add(10, "e")
                + " || add(r)=" + sc2.add("r")
                + " || add(0, t)=" + sc2.add(0, "t"));
        System.out.println("sc2: Elements=" + sc2.size() + " | Capacity=" + sc2.getCapacity());
        System.out.println("StringCollection sc2: " + sc2);

        System.out.println("\nsc1.equals(sc2)=" + sc1.equals(sc2));

        System.out.println("\nsc1.contain(z)=" + sc1.contain("z"));
        System.out.println("sc1.delete(z)=" + sc1.delete("z"));
        System.out.println("sc1.contain(e)=" + sc1.contain("e"));
        System.out.println("sc1.delete(e)=" + sc1.delete("e"));
        System.out.println("sc1.delete(e)=" + sc1.delete("e"));

        System.out.println("\nsc1.equals(sc2)=" + sc1.equals(sc2));
        System.out.println("sc1: Elements=" + sc1.size() + " | Capacity=" + sc1.getCapacity());
        System.out.println("sc2: Elements=" + sc2.size() + " | Capacity=" + sc2.getCapacity());
        System.out.println("StringCollection sc1: " + sc1);
        System.out.println("StringCollection sc2: " + sc2);

        System.out.println("\nsc1.clear()=" + sc1.clear());
        System.out.println("sc1.equals(sc2)=" + sc1.equals(sc2));
        System.out.println("sc1: Elements=" + sc1.size() + " | Capacity=" + sc1.getCapacity());
        System.out.println("sc2: Elements=" + sc2.size() + " | Capacity=" + sc2.getCapacity());
        System.out.println("StringCollection sc1: " + sc1);
        System.out.println("StringCollection sc2: " + sc2);
    }
}
