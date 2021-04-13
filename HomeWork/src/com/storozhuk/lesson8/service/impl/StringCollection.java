package com.storozhuk.lesson8.service.impl;

import com.storozhuk.lesson8.service.Collection;

import java.util.Arrays;

/**
 * Class StringCollection
 *
 * Simple realization of collection of String objects.
 * Capacity of collection is always greater than 1 and doubles
 * when elements count increased.
 */
public class StringCollection implements Collection {
    private String[] arr;
    private int elements = 0; // current number of strings in collection

    public StringCollection(int baseSize) {
        if (baseSize < 1) {
            baseSize = 1;
        }
        this.arr = new String[baseSize];
    }

    public StringCollection() {
        this(10);
    }

    /* Get length of array  */
    public int getCapacity() {
        return this.arr.length;
    }

    @Override
    public boolean add(Object o) {
        /* check object is string */
        if(!(o instanceof String)) {
            return false;
        }

        /* check collection capacity */
        if(this.elements >= this.arr.length) {
            upSize();
        }

        this.arr[this.elements] = (String)o;
        this.elements++;
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        /* check input */
        if(index < 0 || index > this.elements || !(o instanceof String)) {
            return false;
        }

        /* check collection capacity */
        if(this.elements >= this.arr.length) {
            upSize();
        }

        /* shift strings array if needed */
        if(index < this.elements) {
            System.arraycopy(arr, index, arr, index+1, this.elements-index);
        }

        this.arr[index] = (String)o;
        this.elements++;
        return true;
    }

    @Override
    public boolean delete(Object o) {
        /* check object is string */
        if(!(o instanceof String)) {
            return false;
        }

        /* string search */
        int index = -1;
        for(int i = 0; i < this.elements; i++) {
            if(this.arr[i].compareTo((String)o) == 0) {
                index = i;
                break;
            }
        }

        /* return false if not found */
        if(index < 0) {
            return false;
        }

        /* shift strings array if needed */
        if(index < this.elements-1) {
            System.arraycopy(arr, index+1, arr, index, this.elements-index);
        }

        this.elements--;
        this.arr[this.elements] = null;
        return true;
    }

    @Override
    public Object get(int index) {
        /* check input */
        if(index < 0 || index >= this.elements) {
            return null;
        }
        return this.arr[index];
    }

    @Override
    public boolean contain(Object o) {
        /* check object is string */
        if(!(o instanceof String)) {
            return false;
        }

        /* string search */
        for(int i = 0; i < this.elements; i++) {
            if(this.arr[i].compareTo((String)o) == 0) {
                return true;
            }
        }

        /* return false if not found */
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        /* check str is same object */
        if (str == this) {
            return true;
        }

        /* check str is the same type */
        if(str == null || str.getClass() != this.getClass()) {
            return false;
        }

        /* check str is the same len */
        if(str.size() != this.size()) {
            return false;
        }

        /* check elements */
        for(int i = 0; i < this.elements; i++) {
            if(str.get(i) != this.get(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean clear() {
        for(int i = 0; i < this.elements; i++) {
            this.arr[i] = null;
        }
        this.elements = 0;
        return true;
    }

    @Override
    public int size() {
        return this.elements;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(arr, 0, this.elements));
    }

    /* Upsize collection by doubling its capacity */
    private void upSize() {
        this.arr = Arrays.copyOfRange(arr, 0, this.arr.length*2);
    }
}
