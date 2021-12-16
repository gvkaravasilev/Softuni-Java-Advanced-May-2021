package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cows = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = readMatrix(rows, cows, scan);
        char[][] secondMatrix = readMatrix(rows, cows, scan);

        printCharMatrix(getIntersectionOfTwoMatrices(firstMatrix, secondMatrix));

    }

    private static char[][] getIntersectionOfTwoMatrices(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] newMatrix = new char[firstMatrix.length][];

        for (int row = 0; row < firstMatrix.length; row++) {
            newMatrix[row] = new char[firstMatrix[row].length];

            for (int col = 0; col < firstMatrix[row].length; col++) {
                newMatrix[row][col] = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col] : '*';
            }
        }
        return newMatrix;
    }

    public static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }

        return matrix;
    }

    public static void printCharMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
