package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[size][size];

        readMatrix(matrix, size, scan);

        int primaryDiagonal = getPrimaryDiagonal(matrix, size);
        int secondaryDiagonal = getSecondaryDiagonal(matrix, size);

        int difference = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(difference);
    }

    private static int getSecondaryDiagonal(int[][] matrix, int size) {
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(col == size - row - 1){
                    secondaryDiagonalSum += matrix[row][col];
                }
            }
        }
        return secondaryDiagonalSum;
    }

    private static int getPrimaryDiagonal(int[][] matrix, int size) {

        int primaryDiagonalSum = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(row == col){
                    primaryDiagonalSum += matrix[row][col];
                }
            }
        }
        return primaryDiagonalSum;
    }

    private static void readMatrix(int[][] matrix, int size, Scanner scanner) {

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

    }

    public static void printMatrix(int[][] matrix, int size) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
