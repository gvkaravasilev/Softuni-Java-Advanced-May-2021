package JavaAdvancedExamPractise.JavaAdvancedExam22Feb2020;

import java.util.Scanner;

public class Revolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int commandsCount = Integer.parseInt(scan.nextLine());

        int[] playerPositions = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();

            if(line.contains("f")){
                playerPositions[0] = row;
                playerPositions[1] = line.indexOf("f");
            }
        }

        boolean playerWon = false;


        while (commandsCount-- > 0 && !playerWon){
            String command = scan.nextLine();

            if(command.equals("up")){
                playerWon = movePlayer(playerPositions, matrix, -1 , 0);

            }else if(command.equals("down")){
                playerWon = movePlayer(playerPositions, matrix, +1, 0);
            }else if(command.equals("left")){
                playerWon = movePlayer(playerPositions, matrix, 0, -1);
            }else if(command.equals("right")){
                playerWon = movePlayer(playerPositions, matrix, 0, +1);
            }

        }


        if(playerWon){
            System.out.println("Player won!");
        }else{
            System.out.println("Player lost!");
        }

        printMatrix(matrix, size);


    }

    private static boolean movePlayer(int[] playerPositions, char[][] matrix,
                                    int rowModifier, int colModifier) {
        int row = playerPositions[0];
        int col = playerPositions[1];

        int newRow = isInBounds(row + rowModifier, matrix.length);
        int newCol = isInBounds(col + colModifier, matrix.length);


        boolean hasWon = false;

        if(matrix[newRow][newCol] == 'F'){
            hasWon = true;
        }else if(matrix[newRow][newCol] == 'B'){
            newRow = isInBounds(newRow + rowModifier, matrix.length);
            newCol = isInBounds(newCol + colModifier, matrix.length);

            if(matrix[newRow][newCol] == 'F'){
                hasWon = true;
            }
        }else if(matrix[newRow][newCol] == 'T'){
            newRow = row;
            newCol = col;
        }

        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'f';
        playerPositions[0] = newRow;
        playerPositions[1] = newCol;

        return hasWon;
    }

    private static int isInBounds(int index, int length) {
        if(index < 0){
            index = length - 1;
        }else if(index >= length){
            index = 0;
        }
        return index;
    }

    public static void printMatrix(char[][] matrix, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
