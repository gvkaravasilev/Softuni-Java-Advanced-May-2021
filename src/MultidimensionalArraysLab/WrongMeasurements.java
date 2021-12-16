package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];

        matrix = readMatrix(rows, 0, scan, "\\s+");

        int[] wrongValueCoordinates = readArray(scan.nextLine(), "\\s+");

        int wrongValue = matrix[wrongValueCoordinates[0]][wrongValueCoordinates[1]];

        List<int[]> updatedValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    updatedValues.add(new int[]{row, col, getClosestElements(row, col, matrix, wrongValue)});
                }
            }
        }
        for (int[] updatedValue : updatedValues) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }
        printMatrix(matrix);


    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);

        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static boolean isInBounds(int rows, int cols, int[][] matrix) {
        return rows >= 0 && rows < matrix.length && cols >= 0 && cols < matrix[rows].length;
    }

    public static int getClosestElements(int rows, int cols, int[][] matrix, int wrongValue) {
        int sum = 0;

        if (isInBounds(rows, cols + 1, matrix) && matrix[rows][cols + 1] != wrongValue) {
            sum += matrix[rows][cols + 1];
        }
        if (isInBounds(rows, cols - 1, matrix) && matrix[rows][cols - 1] != wrongValue) {
            sum += matrix[rows][cols - 1];
        }
        if (isInBounds(rows + 1, cols, matrix) && matrix[rows + 1][cols] != wrongValue) {
            sum += matrix[rows + 1][cols];
        }
        if (isInBounds(rows - 1, cols, matrix) && matrix[rows - 1][cols] != wrongValue) {
            sum += matrix[rows - 1][cols];
        }
        return sum;
    }
}
