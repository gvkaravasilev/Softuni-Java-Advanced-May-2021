package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2by2SubMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = readArray(scan.nextLine(), ", ");

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(rows, cols, scan, ", ");

        int[][] maxSubMatrix = getMaxSumOfSubMatrix2By2(matrix);

        printMatrix(maxSubMatrix);
        System.out.println(getSumOfMatrix(maxSubMatrix));


    }

    private static int getSumOfMatrix(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }


        return sum;
    }

    private static int[][] getMaxSumOfSubMatrix2By2(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

    return new int[][]{
            {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
            {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
    };

}

    public static int[] readArray(String line, String pattern){
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }

        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }
    }

}
