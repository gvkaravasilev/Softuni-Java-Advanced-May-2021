package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstMatrixDimensions = readArray(scan.nextLine(), "\\s+");
        int firstMatrixRows = firstMatrixDimensions[0];
        int fistMatrixCols = firstMatrixDimensions[1];

        int[][] firstMatrix = readMatrix(firstMatrixRows, fistMatrixCols, scan, "\\s+");

        int[] secondMatrixDimensions = readArray(scan.nextLine(),"\\s+");

        int secondMatrixRows = secondMatrixDimensions[0];
        int secondMatrixCols = secondMatrixDimensions[0];

        int[][] secondMatrix = readMatrix(secondMatrixRows, secondMatrixCols, scan, "\\s+");

        if(matricesAreEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }

    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArray = firstMatrix[row];
            int[] secondArray = secondMatrix[row];
            
            if(firstArray.length != secondArray.length){
                return false;
            }
            for (int cow = 0; cow < firstArray.length; cow++) {
                if(firstArray[cow] != secondArray[cow]){
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }

        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
