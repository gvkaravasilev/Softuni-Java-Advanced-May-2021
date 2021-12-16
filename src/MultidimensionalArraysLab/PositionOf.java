package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = readArray(scan.nextLine(), "\\s+");

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(rows, cols, scan, "\\s+");
        
        int number = Integer.parseInt(scan.nextLine());
        
        List<int []> positionsOfNumber = findNumberOccurrences(matrix, number);

        if(positionsOfNumber.isEmpty()){
            System.out.println("not found");
        }else{
            for (int[] arrays : positionsOfNumber) {
                for (int element : arrays) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }


    }

    private static List<int[]> findNumberOccurrences(int[][] matrix, int number) {
        List<int[]> numberOccurrences = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == number){
                    numberOccurrences.add(new int[]{row, col});
                }
            }
        }

        return numberOccurrences;
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
}