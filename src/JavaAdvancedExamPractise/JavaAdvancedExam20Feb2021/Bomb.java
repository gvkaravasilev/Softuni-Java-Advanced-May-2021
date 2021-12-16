package JavaAdvancedExamPractise.JavaAdvancedExam20Feb2021;

import java.util.Scanner;

public class Bomb {
    static int countBombs = 0;
    static int numberOfAllBombs = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        String[] command = scan.nextLine().split(",");

        int[] playerPositions = new int[2];

        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col].charAt(0);

                if(matrix[row][col] == 's'){
                    playerPositions[0] = row;
                    playerPositions[1] = col;
                }
                if(matrix[row][col] == 'B'){
                    numberOfAllBombs++;
                }
            }
        }

        boolean isNotFinished = true;


        for (int i = 0; i < command.length; i++) {
            String currentCommand = command[i];

            while (numberOfAllBombs > 0 && isNotFinished) {
                if (currentCommand.equals("up")) {
                    isNotFinished = movePlayer(playerPositions, matrix, -1, 0);
                    break;
                } else if (currentCommand.equals("down")) {
                    isNotFinished = movePlayer(playerPositions, matrix, +1, 0);
                    break;
                } else if (currentCommand.equals("left")) {
                    isNotFinished = movePlayer(playerPositions, matrix, 0, -1);
                    break;
                } else if (currentCommand.equals("right")) {
                    isNotFinished = movePlayer(playerPositions, matrix, 0, +1);
                    break;
                }
            }
            if (numberOfAllBombs == 0) {
                System.out.println("Congratulations! You found all bombs!");
                break;
            }

        }



        if (numberOfAllBombs > 0 && isNotFinished) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", numberOfAllBombs, playerPositions[0], playerPositions[1]);
        }


    }

    private static boolean movePlayer(int[] playerPositions, char[][] matrix, int rowModifier, int colModifier) {

        int row = playerPositions[0];
        int col = playerPositions[1];

        matrix[row][col] = '+';

        int newRow = row + rowModifier;
        int newCol = col + colModifier;

        if (isOutOfBounds(newRow, newCol, matrix)) {
            newRow = row;
            newCol = col;
            return true;
        }

        char currentSymbol = matrix[newRow][newCol];

        if (currentSymbol == 'B') {
            matrix[newRow][newCol] = '+';
            countBombs++;
            numberOfAllBombs--;
            System.out.println("You found a bomb!");

        } else if (currentSymbol == 'e') {
            System.out.printf("END! %d bombs left on the field%n", numberOfAllBombs);
            row = newRow;
            col = newCol;
            return false;
        }

        matrix[newRow][newCol] = 's';
        playerPositions[0] = newRow;
        playerPositions[1] = newCol;

        return true;
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] matrix) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }


    public static void printMatrix(char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
