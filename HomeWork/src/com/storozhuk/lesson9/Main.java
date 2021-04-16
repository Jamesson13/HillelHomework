package com.storozhuk.lesson9;

import com.storozhuk.lesson9.service.impl.CustomCollection;

/*
 * Реализовать коллекцию на основе связного списка
 */
public class Main {
    public static void main(String[] args) {
        CustomCollection list1 = new CustomCollection();
        CustomCollection list2 = new CustomCollection();
        CustomCollection list3 = new CustomCollection();

        System.out.println("\nEmpty collections:");
        System.out.println(list1 + " Size:" + list1.size());
        System.out.println(list2 + " Size:" + list2.size());
        System.out.println(list3 + " Size:" + list3.size());

        System.out.println("\nlist1.add(q)=" + list1.add("q"));
        System.out.println("list1.add(w)=" + list1.add("w"));
        System.out.println("list1.add(e)=" + list1.add("e"));
        System.out.println("list1.add(r)=" + list1.add("r"));

        String[] arr = {"q", "w", "e", "r", "t"};
        System.out.println("list2.add([q, w, e, r, t])=" + list2.addAll(arr));

        System.out.println("list3.add(list1)=" + list3.addAll(list1));

        System.out.println("\nCollections:");
        System.out.println(list1 + " Size:" + list1.size());
        System.out.println(list2 + " Size:" + list2.size());
        System.out.println(list3 + " Size:" + list3.size());

        System.out.println("\nlist1.delete(0)=" + list1.delete(0));
        System.out.println("list1.delete(8)=" + list1.delete(8));
        System.out.println("list1.delete(2)=" + list1.delete(2));

        System.out.println("\nlist2.delete(v)=" + list2.delete("v"));
        System.out.println("list2.delete(q)=" + list2.delete("q"));
        System.out.println("list2.delete(t)=" + list2.delete("t"));

        System.out.println("\nlist3.get(0)=" + list3.get(0));
        System.out.println("list3.get(9)=" + list3.get(9));
        System.out.println("list3.get(2)=" + list3.get(2));

        System.out.println("\nCollections:");
        System.out.println(list1 + " Size:" + list1.size());
        System.out.println(list2 + " Size:" + list2.size());
        System.out.println(list3 + " Size:" + list3.size());

        System.out.println();
        System.out.println("list1.add(r)=" + list1.add("r"));
        System.out.println("list2.trim()=" + list2.trim());
        System.out.println("list3.contains(e)=" + list3.contains("e"));
        System.out.println("list3.contains(x)=" + list3.contains("x"));
        System.out.println("list3.clear()=" + list3.clear());

        System.out.println("\nCollections:");
        System.out.println(list1 + " Size:" + list1.size());
        System.out.println(list2 + " Size:" + list2.size());
        System.out.println(list3 + " Size:" + list3.size());

        System.out.println();
        System.out.println("list1.compare(list2)=" + list1.compare(list2));
        System.out.println("list2.compare(list3)=" + list2.compare(list3));
        System.out.println("list3.compare(list1)=" + list3.compare(list1));

        System.out.println();
        System.out.println("list1.add(z)=" + list1.add("z"));
        System.out.println("list2.add(x)=" + list2.add("x"));
        System.out.println("list3.add(c)=" + list3.add("c"));

        System.out.println("\nCollections:");
        System.out.println(list1 + " Size:" + list1.size());
        System.out.println(list2 + " Size:" + list2.size());
        System.out.println(list3 + " Size:" + list3.size());
    }
}
