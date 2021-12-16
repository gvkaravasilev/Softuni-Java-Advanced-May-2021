package JavaAdvancedExamPractise.JavaAdvancedExam16Dec2020;

import java.util.Scanner;



public class Selling {
    static int money = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int[] playerPositions = new int[2];

        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();

            if(line.contains("S")){
                playerPositions[0] = row;
                playerPositions[1] = line.indexOf('S');
            }
        }

        boolean isInBakery = true;


        while (isInBakery && money < 50){

            String command = scan.nextLine();

            if(command.equals("up")){
                isInBakery = movePlayer(playerPositions, matrix, -1, 0);
            }else if(command.equals("down")){
                isInBakery = movePlayer(playerPositions, matrix, +1 , 0);
            }else if(command.equals("left")){
                isInBakery = movePlayer(playerPositions, matrix, 0 , -1);
            }else if(command.equals("right")){
                isInBakery = movePlayer(playerPositions, matrix, 0 , +1);
            }

        }


        if(!isInBakery){
            System.out.println("Bad news, you are out of the bakery.");
        }else{
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);

        printMatrix(matrix, size);

    }

    private static boolean movePlayer(int[] playerPositions, char[][] matrix, int rowModifier, int colModifier) {
        int row = playerPositions[0];
        int col = playerPositions[1];

        matrix[row][col] = '-';



        int newRow = row + rowModifier;
        int newCol = col + colModifier;


        if(isOutOfBounds(newRow, newCol, matrix)){
            return false;
        }


        char symbol = matrix[newRow][newCol];

        if(Character.isDigit(symbol)){
            money += symbol - '0';
        }else if(symbol == 'O'){
            matrix[newRow][newCol] = '-';

            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if(matrix[r][c] == 'O'){
                        newRow = r;
                        newCol = c;
                        break;
                    }
                }
                if(matrix[newRow][newCol] == 'O'){
                    break;
                }
            }
        }



        matrix[newRow][newCol] = 'S';
        playerPositions[0] = newRow;
        playerPositions[1] = newCol;

        return true;
    }

    public static void printMatrix(char[][] matrix, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static boolean isOutOfBounds(int row, int col, char[][] matrix){
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public static int[] findSecondPillar(char[][] matrix){
        int[] indexes = null;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'O'){
                    indexes = new int[]{row, col};
                    break;
                }
            }
            if (indexes != null){
                break;
            }
        }

        return indexes;
    }
}
