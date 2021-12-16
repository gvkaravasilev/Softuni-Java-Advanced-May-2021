package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfRowsAndCols = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[numberOfRowsAndCols][numberOfRowsAndCols];

        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = scan.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
        List<Integer> principleDiagonal = getPrincipleDiagonal(matrix);
        List<Integer> secondaryDiagonal = getSecondaryDiagonal(matrix);

        for (Integer integer : principleDiagonal) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : secondaryDiagonal) {
            System.out.print(integer + " ");
        }
    }

    private static List<Integer> getSecondaryDiagonal(int[][] matrix) {
        List<Integer> secondaryDiagonalElements = new ArrayList<>();

        int col = 0;

        for (int row = matrix.length - 1 ; row >= 0 ; row--) {
            secondaryDiagonalElements.add(matrix[row][col]);
            col++;
        }
        return secondaryDiagonalElements;
    }

    private static List<Integer> getPrincipleDiagonal(int[][] matrix) {

        List<Integer> principleDiagonalElements = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    principleDiagonalElements.add(matrix[row][col]);
                }
            }
        }
        return principleDiagonalElements;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
