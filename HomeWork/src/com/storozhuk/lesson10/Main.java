package com.storozhuk.lesson10;

import com.storozhuk.lesson10.service.impl.StringCollectionIterator;
import com.storozhuk.lesson8.service.impl.StringCollection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.storozhuk.lesson10.service.DuplicatesRemover.withoutDuplicates;

/*
 * 1. Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.
 * 2. Написать итератор по коллекции реализованной в ДЗ №8.
 * 3. Написать программу для вычисления корней квадратного уравнения.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\nTask1. Removing duplicates:");
        String[] strArr = new String[] {"1", "2", "3", "5", "1", "6", "2", "7", "8", "5", "9", "9"};
        List<String> list = new LinkedList<>(Arrays.asList(strArr));
        System.out.println(list);
        System.out.println(withoutDuplicates(list));

        System.out.println("\nTask2. Implementation of Iterator for StringCollection:");
        StringCollection stringCollection = new StringCollection();
        for(String s : strArr) {
            stringCollection.add(s);
        }
        System.out.println(stringCollection);
        StringCollectionIterator iterator = new StringCollectionIterator(stringCollection);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
