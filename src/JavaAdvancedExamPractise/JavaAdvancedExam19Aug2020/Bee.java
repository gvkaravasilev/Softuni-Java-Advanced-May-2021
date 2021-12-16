package JavaAdvancedExamPractise.JavaAdvancedExam19Aug2020;

import java.util.Scanner;

public class Bee {
    static int pollinatedFlowers = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int[] beePositions = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("B")) {
                beePositions[0] = row;
                beePositions[1] = line.indexOf("B");
            }
        }

        boolean isInTerritory = true;




        while (isInTerritory) {

            String command = scan.nextLine();

            if(command.equals("End")){
                break;
            }

            if (command.equals("up")) {
                isInTerritory = moveBee(beePositions, matrix, -1, 0);
            } else if (command.equals("down")) {

                isInTerritory = moveBee(beePositions, matrix, +1, 0);

            } else if (command.equals("left")) {
                isInTerritory = moveBee(beePositions, matrix, 0, -1);

            } else if (command.equals("right")) {
                isInTerritory = moveBee(beePositions, matrix, 0, +1);
            }

        }

        if(!isInTerritory){
            System.out.println("The bee got lost!");
        }

        if(pollinatedFlowers >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        printMatrix(matrix, size);

    }

    private static boolean moveBee(int[] beePositions, char[][] matrix, int rowModifier, int colModifier) {

        int row = beePositions[0];
        int col = beePositions[1];

        matrix[row][col] = '.';


        int newRol = row + rowModifier;
        int newCol = col + colModifier;

        if(isOutOfBounds(newRol, newCol, matrix)){
            return false;
        }

        char symbol = matrix[newRol][newCol];

        if(symbol == 'f'){
            pollinatedFlowers++;
        }else if(symbol == 'O'){
            matrix[newRol][newCol] = '.';


            newRol = newRol + rowModifier;
            newCol = newCol + colModifier;

            if(matrix[newRol][newCol] == 'f'){
                pollinatedFlowers++;
            }
        }

        matrix[newRol][newCol] = 'B';
        beePositions[0] = newRol;
        beePositions[1] = newCol;

        return true;
    }

    private static boolean isOutOfBounds(int newRol, int newCol, char[][] matrix) {
        return newRol < 0 || newRol >= matrix.length || newCol < 0 || newCol >= matrix[newRol].length;
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
