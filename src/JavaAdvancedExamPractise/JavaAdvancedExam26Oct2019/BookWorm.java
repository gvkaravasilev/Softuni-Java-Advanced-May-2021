package JavaAdvancedExamPractise.JavaAdvancedExam26Oct2019;

import java.util.Scanner;

public class BookWorm {
    static String word = "";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        word = scan.nextLine();

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int[] wormPositions = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();

            matrix[row] = line.toCharArray();

            if(line.contains("P")){
                wormPositions[0] = row;
                wormPositions[1] = line.indexOf('P');
            }
        }

        String command = scan.nextLine();



        while (!command.equals("end")){

            if(command.equals("up")){

                moveWorm(wormPositions, matrix, -1, 0);

            }else if(command.equals("down")){


                moveWorm(wormPositions, matrix, +1 , 0);

            }else if(command.equals("left")){

                moveWorm(wormPositions, matrix, 0, -1);

            }else if(command.equals("right")){
                moveWorm(wormPositions, matrix, 0, +1);

            }


            command = scan.nextLine();
        }

        System.out.println(word);

        printMatrix(matrix, size);
    }

    private static void moveWorm(int[] wormPositions, char[][] matrix, int rowModifier, int colModifier) {
        int row = wormPositions[0];
        int col = wormPositions[1];

        int newRow = row + rowModifier;
        int newCol = col + colModifier;

        if(isOutOfBounds(newRow, newCol, matrix)){
            if(word.length() > 0){

                newRow = row;
                newCol = col;

                word = word.substring(0, word.length() - 1);
            }
        }

        char symbol = matrix[newRow][newCol];

        if(Character.isLetter(symbol) && symbol != 'P'){
            word += symbol;
            matrix[newRow][newCol] = '-';
        }

        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'P';
        wormPositions[0] = newRow;
        wormPositions[1] = newCol;

    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] matrix) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }

    private static void printMatrix(char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
