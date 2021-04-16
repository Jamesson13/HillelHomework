package com.storozhuk.lesson9.dto;

/**
 * Class Node
 *
 * Node contains data string and link to next node.
 * Used to implement simple linked list.
 */
public class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    /* getters and setters */
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
