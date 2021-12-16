package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(", ");

        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[size][size];



       if(pattern.equals("A")){
           fillPatternA(matrix, size);
       }else if(pattern.equals("B")){
           fillPatternB(matrix, size);
       }

       printMatrix(matrix, size);

    }

    private static void fillPatternB(int[][] matrix, int size) {
        int startNumber = 1;

        for (int col = 0; col < size; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber++;
                }
            }else{
                for (int row = size - 1; row >= 0 ; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix, int size) {

        int startNumber = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
