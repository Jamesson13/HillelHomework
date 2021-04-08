package lesson7.utils;

import java.util.Arrays;

/**
 * Class StringCollection
 *
 * Simple realization of collection of String objects.
 * Capacity of collection is always greater than 1 and doubles
 * when elements count increased.
 */
public class StringCollection {
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

    /* Get number of elements in array */
    public int getSize() {
        return this.elements;
    }

    /* Get length of array  */
    public int getCapacity() {
        return this.arr.length;
    }

    /* Add a string into specified position of the collection  */
    public boolean add(String str, int index) {
        /* check input */
        if(index < 0 || index > this.elements || str == null) {
            return false;
        }

        /* check collection capacity */
        if(this.elements >= this.arr.length) {
            upSize();
        }

        /* shift strings array if needed */
        if(index < this.elements) {
            for(int i = this.elements; i > index ; i--) {
                arr[i] = arr[i-1];
            }
        }

        this.arr[index] = str;
        this.elements++;
        return true;
    }

    /* Add a string at the end of the collection */
    public boolean add(String str) {
        /* check input */
        if(str == null) {
            return false;
        }

        /* check collection capacity */
        if(this.elements >= this.arr.length) {
            upSize();
        }

        this.arr[this.elements] = str;
        this.elements++;
        return true;
    }

    /* Remove string from specified position of the collection  */
    public boolean delete(int index) {
        /* check input */
        if(index < 0 || index >= this.elements) {
            return false;
        }

        /* shift strings array if needed */
        if(index < this.elements-1) {
            for(int i = index; i < this.elements ; i++) {
                arr[i] = arr[i+1];
            }
        }

        this.elements--;
        this.arr[this.elements] = null;
        return true;
    }

    /* Remove string from the collection if exists */
    public boolean delete(String str) {
        /* check input */
        if(str == null) {
            return false;
        }

        /* string search */
        Integer index = null;
        for(int i = 0; i < this.elements; i++) {
            if(this.arr[i].compareTo(str) == 0) {
                index = i;
                break;
            }
        }

        /* return false if not found */
        if(index == null) {
            return false;
        }

        /* shift strings array if needed */
        if(index < this.elements-1) {
            for(int i = index; i < this.elements ; i++) {
                arr[i] = arr[i+1];
            }
        }

        this.elements--;
        this.arr[this.elements] = null;
        return true;
    }

    /* Get string from specified position of the collection */
    public String get(int index) {
        /* check input */
        if(index < 0 || index >= this.elements) {
            return null; /* TODO: Throw an exception if string not found */
        }
        return this.arr[index];
    }

    @Override
    public String toString() {
        return "StringCollection{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    /* Upsize collection by doubling its capacity */
    private void upSize() {
        String[] tmp = new String[this.arr.length*2];

        /* manual copy */
        for(int i = 0; i < this.arr.length; i++) {
            tmp[i] = this.arr[i];
        }
        this.arr = tmp;
    }
}
