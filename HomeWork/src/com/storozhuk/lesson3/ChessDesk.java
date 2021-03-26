package com.storozhuk.lesson3;

/*
 * Task 13
 *
 * Print the 8x8 chess desk as 2-dim array
 */

public class ChessDesk {
    public static void main(String[] args) {
        int xSize = 8;
        int ySize = 8;
        Boolean isWhite;

        for(int i = 0; i < xSize; i++) {
            isWhite = (i%2 == 0); // change color for next row
            for(int j = 0; j < ySize; j++) {
                if(isWhite) {
                    System.out.print("W ");
                } else {
                    System.out.print("B ");
                }
                isWhite = !isWhite; // swap color for next cell
            }
            System.out.print("\n");
        }
    }
}
