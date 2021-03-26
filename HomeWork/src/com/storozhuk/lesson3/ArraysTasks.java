package com.storozhuk.lesson3;

/*
 * Tasks 8-12
 *
 * 8. Create array with first 10 odd numbers and print in one string
 * with comma.
 * 9. In array N find elements with minimum value and print it.
 * 10. In array N find element with maximum value.
 * 11. In array N swap the largest and smallest elements.
 * 12. Print average of values of array N.
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        int[] input;

        /* Entering the array from console */
        System.out.print("Enter array size N:");
        N = sc.nextInt();

        if(N <= 0) {
            System.out.println("Array size must be greater than 0.");
            return;
        }

        input = new int[N];
        for(int i = 0; i < input.length; i++) {
            System.out.print("Enter element input[" + i + "]:");
            input[i] = sc.nextInt();
        }

        /* Tasks */
        fistOddNumbers(10);
        System.out.println("-------------------------------------------");

        System.out.println("Input array:");
        System.out.println(Arrays.toString(input));
        printMinimum(input);
        printMaximum(input);
        System.out.println("-------------------------------------------");

        System.out.println("Input array:");
        System.out.println(Arrays.toString(input));
        swapMinMax(input);
        System.out.println("Array after values swap:");
        System.out.println(Arrays.toString(input));
        System.out.println("-------------------------------------------");

        averageOfArray(input);
        System.out.println("-------------------------------------------");
    }

    /* Create array with first maxCount odd numbers and print in one string */
    private static void fistOddNumbers(int maxCount) {
        int[] arr = new int[maxCount];
        int cnt = 0;

        /* fill the array */
        for(int i = 0; ; i++) {
            if(i % 2 == 1) {
                arr[cnt] = i;
                cnt++;
            }
            if(cnt >= maxCount) {
                break;
            }
        }

        /* print the array */
        System.out.println("Array with first " + maxCount + " odd numbers:");
        for(int n = 0; n < arr.length ; n++) {
            System.out.print(arr[n]);
            /* print commas or carriage return if element is last */
            if (n < arr.length - 1) {
                System.out.print(", ");
            }
            else {
                System.out.print("\n");
            }
        }
    }

    /* Find elements with minimum value in arr and print it */
    private static void printMinimum(int[] arr) {
        int minVal = arr[0];

        /* find minimum */
        for(int n : arr) {
            if(n < minVal) {
                minVal = n;
            }
        }

        /* print values */
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == minVal) {
                System.out.println("Minimum: arr[" + i + "] = " + arr[i]);
            }
        }
    }

    /* Find elements with maximum value in arr and print it */
    private static void printMaximum(int[] arr) {
        int maxVal = arr[0];

        /* find minimum */
        for(int n : arr) {
            if(n > maxVal) {
                maxVal = n;
            }
        }

        /* print values */
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == maxVal) {
                System.out.println("Maximum: arr[" + i + "] = " + arr[i]);
            }
        }
    }

    /* Swap the largest and smallest elements in array arr (first if multiple count) */
    private static void swapMinMax(int[] arr) {
        /* [ index , value ] */
        int[] maxVal = new int[] {0, arr[0]};
        int[] minVal = new int[] {0, arr[0]};

        /* find minimum and maximum */
        for(int n = 0; n < arr.length; n++) {
            if(arr[n] > maxVal[1]) {
                maxVal[1] = arr[n];
                maxVal[0] = n;
            }
            if(arr[n] < minVal[1]) {
                minVal[1] = arr[n];
                minVal[0] = n;
            }
        }

        /* swap */
        arr[maxVal[0]] = minVal[1];
        arr[minVal[0]] = maxVal[1];
    }

    /* Print average of elements off array arr */
    private static void averageOfArray(int[] arr) {
        int sum = 0;
        for(int n : arr) {
            sum += n;
        }
        System.out.println("Average of values of array: " + ((double)sum/(double)arr.length));
    }
}


