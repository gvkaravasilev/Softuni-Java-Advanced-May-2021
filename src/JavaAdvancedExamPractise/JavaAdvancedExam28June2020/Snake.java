package JavaAdvancedExamPractise.JavaAdvancedExam28June2020;

import java.util.Scanner;

public class Snake {
    static int snakeFood = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int[] snakePositions = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("S")) {
                snakePositions[0] = row;
                snakePositions[1] = line.indexOf('S');
            }
        }

        boolean isInTerritory = true;

        while (isInTerritory && snakeFood < 10) {

            String command = scan.nextLine();

            if (command.equals("up")) {

                isInTerritory = movePlayer(snakePositions, matrix, -1, 0);

            } else if (command.equals("down")) {

                isInTerritory = movePlayer(snakePositions, matrix, +1, 0);

            } else if (command.equals("left")) {

                isInTerritory = movePlayer(snakePositions, matrix, 0, -1);
            } else if (command.equals("right")) {

                isInTerritory = movePlayer(snakePositions, matrix, 0, +1);
            }
        }


        if (!isInTerritory) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", snakeFood);

        printMatrix(matrix, size);


    }

    private static void printMatrix(char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean movePlayer(int[] snakePositions, char[][] matrix, int rowModifier, int colModifier) {
        int row = snakePositions[0];
        int col = snakePositions[1];


        int newRol = row + rowModifier;
        int newCol = col + colModifier;

        if (isOutOfBounds(newRol, newCol, matrix)) {
            matrix[row][col] = '.';
            return false;
        }

        char symbol = matrix[newRol][newCol];

        if (symbol == '*') {


            matrix[newRol][newCol] = '.';

            snakeFood++;

        } else if (symbol == 'B') {


            matrix[newRol][newCol] = '.';

            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if (matrix[r][c] == 'B') {
                        matrix[r][c] = 'S';

                        matrix[newRol][newCol] = '.';
                        matrix[row][col] = '.';
                        newRol = r;
                        newCol = c;
                        break;
                    }
                }
                if (matrix[newRol][newCol] == 'B') {
                    break;
                }
            }
        }

        matrix[newRol][newCol] = 'S';
        matrix[row][col] = '.';
        snakePositions[0] = newRol;
        snakePositions[1] = newCol;

        return true;
    }

    private static boolean isOutOfBounds(int newRol, int newCol, char[][] matrix) {
        return newRol < 0 || newRol >= matrix.length || newCol < 0 || newCol >= matrix[newRol].length;
    }

}
