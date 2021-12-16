package JavaAdvancedExamPractise.JavaAdvanced23Oct2019;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TheGarden {
    static char[][] matrix;
    static int harmedVegetables;
    static Map<String, Integer> vegetables;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rowsCount = Integer.parseInt(scan.nextLine());

        readMatrix(scan, rowsCount);

        String input = scan.nextLine();

        vegetables = new LinkedHashMap<>();

        vegetables.put("Carrots", 0);
        vegetables.put("Potatoes", 0);
        vegetables.put("Lettuce", 0);


        while (!input.equals("End of Harvest")) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if (command.equals("Harvest")) {

                addVegetables(row, col);

            } else if (command.equals("Mole")) {
                String direction = tokens[3];


                if (isInBounds(matrix, row, col)) {
                    if (direction.equals("up")) {

                        move(row, col, -2, "rows");
                    } else if (direction.equals("down")) {
                        move(row, col, +2, "rows");
                    } else if (direction.equals("left")) {
                        move(row, col, -2, "cols");
                    } else if (direction.equals("right")) {
                        move(row, col, +2, "cols");
                    }
                }

            }

            input = scan.nextLine();
        }

        printMatrix(matrix);

        vegetables.entrySet().forEach(
                e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue())
        );

        System.out.printf("Harmed vegetables: %d", harmedVegetables);

    }

    private static void addVegetables(int row, int col) {
        if(isInBounds(matrix, row, col)){
            char currentChar = matrix[row][col];

            if(currentChar == 'L'){
                vegetables.put("Lettuce", vegetables.get("Lettuce") + 1);
            }else if(currentChar == 'P'){
                vegetables.put("Potatoes", vegetables.get("Potatoes") + 1);
            }else if(currentChar == 'C'){
                vegetables.put("Carrots", vegetables.get("Carrots") + 1);
            }

            matrix[row][col] = ' ';
        }
    }

    public static void move(int row, int col, int index, String direction) {
        while (isInBounds(matrix, row, col)) {
            if (matrix[row][col] != ' ') {
                harmedVegetables++;
                matrix[row][col] = ' ';
            }

            if (direction.equals("rows")) {
                row = Math.abs(row) + index;
            } else if (direction.equals("cols")) {
                col = Math.abs(col) + index;
            }
        }
    }

    private static void readMatrix(Scanner scan, int rowsCount) {
        matrix = new char[rowsCount][];

        for (int row = 0; row < rowsCount; row++) {
            matrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
