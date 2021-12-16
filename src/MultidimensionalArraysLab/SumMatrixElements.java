package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = readArray(scan.nextLine(), ", ");
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(rows, cols, scan, ", ");

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getMatrixSum(matrix));

    }

    private static int getMatrixSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                sum += matrix[row][cow];
            }
        }

        return sum;
    }

    public static int[] readArray(String line, String pattern){
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner.nextLine(), ", ");
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                System.out.print(matrix[row][cow] + " ");
            }
            System.out.println();
        }
    }
}
