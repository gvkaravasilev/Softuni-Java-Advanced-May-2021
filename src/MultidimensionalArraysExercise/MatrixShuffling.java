package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        readMatrix(matrix, rows, cols, scan);

        String input = scan.nextLine();

        while (!input.equals("END")) {


            if (!isValidCommand(input, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String[] tokens = input.split("\\s+");

                int rowFirst = Integer.parseInt(tokens[1]);
                int colFirst = Integer.parseInt(tokens[2]);
                int rowSecond = Integer.parseInt(tokens[3]);
                int colSecond = Integer.parseInt(tokens[4]);

                String firstElement = matrix[rowFirst][colFirst];
                String secondElement = matrix[rowSecond][colSecond];

                matrix[rowFirst][colFirst] = secondElement;
                matrix[rowSecond][colSecond] = firstElement;

                printMatrix(matrix, rows, cols);
            }


            input = scan.nextLine();
        }



    }

    private static boolean isValidCommand(String input, int rows, int cols) {

        String[] tokens = input.split("\\s+");

        String command = tokens[0];

        if (!command.equals("swap")) {
            return false;
        }

        if (tokens.length != 5) {
            return false;
        }

        int firstRowCoordinate = Integer.parseInt(tokens[1]);
        int firstColCoordinate = Integer.parseInt(tokens[2]);
        int secondRowCoordinate = Integer.parseInt(tokens[3]);
        int secondColCoordinate = Integer.parseInt(tokens[4]);

        if (firstRowCoordinate < 0
                || secondRowCoordinate < 0
                || firstRowCoordinate >= rows
                || secondRowCoordinate >= rows || firstColCoordinate < 0
                || secondColCoordinate < 0
                || firstColCoordinate >= cols
                || secondColCoordinate >= cols) {
            return false;

        }
        return true;
    }


    private static void printMatrix(String[][] matrix, int rows, int cols) {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(String[][] matrix, int rows, int cols, Scanner scanner) {

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
