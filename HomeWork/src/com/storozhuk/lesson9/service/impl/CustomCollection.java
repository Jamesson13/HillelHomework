package com.storozhuk.lesson9.service.impl;

import com.storozhuk.lesson9.dto.Node;
import com.storozhuk.lesson9.service.Collection;

/**
 * Class CustomCollection
 *
 * Realization of simple singly linked list.
 */
public class CustomCollection implements Collection {
    private Node first; // first element of the collection
    private Node last; // last element of the collection

    public CustomCollection() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public boolean add(String str) {
        /* check string isn't null */
        if (str == null) {
            return false;
        }

        /* create new node */
        Node newNode = new Node(str);

        /* if collection is empty => set new node as first */
        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }

        this.last = newNode;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {
        /* check strArr isn't null */
        if (strArr == null) {
            return false;
        }

        /* add strings */
        for (String s : strArr) {
            if(!add(s)) {
                return false; // failed to add string
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        /* check strColl is the same type */
        if (!(strColl instanceof CustomCollection)) {
            return false;
        }

        /* check strColl is not empty */
        if (((CustomCollection) strColl).isEmpty()) {
            return false;
        }

        /* add strings */
        for(int i = 0; i < strColl.size(); i++) {
            if(!add(strColl.get(i))) {
                return false; // failed to add string from strColl
            }
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        /* check input and collection isn't empty */
        if(index < 0 || this.isEmpty()) {
            return false;
        }

        int currentIndex = 0;
        Node current = this.first;
        Node previous = this.first;

        /* find node */
        while(currentIndex < index) {
            previous = current;
            current = current.getNext();
            currentIndex++;
            if(current == null) {
                return false; // not found
            }
        }

        /* skip node */
        if(current == this.first) {
            this.first = this.first.getNext();
        } else {
            previous.setNext(current.getNext());
            /* if del last => set previous as last */
            if (current == this.last) {
                this.last = previous;
            }
        }
        return true;
    }

    @Override
    public boolean delete(String str) {
        /* check str isn't null and collection isn't empty */
        if (str == null || this.isEmpty()) {
            return false;
        }

        Node current = this.first;
        Node previous = this.first;

        while(current != null) {
            if(current.getData().compareTo(str) == 0) {
                /* skip node */
                if(current == this.first) {
                    this.first = this.first.getNext();
                } else {
                    previous.setNext(current.getNext());
                    /* if del last => set previous as last */
                    if (current == this.last) {
                        this.last = previous;
                    }
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String get(int index) {
        /* check input and collection isn't empty */
        if(index < 0 || this.isEmpty()) {
            return null;
        }

        int currentIndex = 0;
        Node current = this.first;

        /* search for needed node */
        while(currentIndex < index) {
            current = current.getNext();
            currentIndex++;
            if(current == null) {
                return null; // not found
            }
        }

        return current.getData();
    }

    @Override
    public boolean contains(String str) {
        /* check str isn't null and collection isn't empty */
        if (str == null || this.isEmpty()) {
            return false;
        }

        Node current = this.first;

        while(current != null) {
            if(current.getData().compareTo(str) == 0) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean clear() {
        /* deleting first elements until get null link of next node */
        while(this.first != null) {
            this.first = this.first.getNext();
        }
        this.last = null;
        return true;
    }

    @Override
    public int size() {
        int size = 0;
        Node current = this.first;

        while(current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public boolean trim() {
        return true;
    }

    @Override
    public boolean compare(Collection coll) {
        /* check coll is the same object */
        if (coll == this) {
            return true;
        }

        /* check coll is the same type */
        if (!(coll instanceof CustomCollection)) {
            return false;
        }

        /* check coll is the same size */
        if (coll.size() != this.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).compareTo(coll.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        Node current = this.first;
        String output = "[";
        while(current != null) {
            output = output.concat(current.getData());
            current = current.getNext();
            /* add comma */
            if (current != null) {
                output = output.concat(",");
            }
        }
        output = output.concat("]");
        return output;
    }
}
