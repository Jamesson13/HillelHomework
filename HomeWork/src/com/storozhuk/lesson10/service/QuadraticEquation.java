package com.storozhuk.lesson10.service;

/**
 * Class QuadraticEquation
 *
 * Contains static method getRoots() which returns array of roots.
 */
public class QuadraticEquation {
    public static double[] getRoots(double a, double b, double c) {
        double d = b*b-4*a*c;
        if(d < 0) {
            return null; /* TODO throw exception */
        } else if (d == 0) {
            return new double[] {-b/(2*a)};
        } else {
            return new double[] {(-b+Math.sqrt(d))/(2*a), (-b-Math.sqrt(d))/(2*a)};
        }
    }
}
