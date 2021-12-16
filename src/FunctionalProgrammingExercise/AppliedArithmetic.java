package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scan.nextLine();

        Function<int[], int[]> addToArray = array ->
                Arrays.stream(array)
                .boxed()
                .mapToInt(e -> e + 1)
                .toArray();

        Function<int[], int[]> multiply = array ->
                Arrays.stream(array)
                        .boxed()
                        .mapToInt(e -> e * 2)
                        .toArray();

        Function<int[], int[]> subtractFromArray = array ->
                Arrays.stream(array)
                        .boxed()
                        .mapToInt(e -> e - 1)
                        .toArray();

        Consumer<int[]> printArray = array ->
                Arrays.stream(array).forEach(e -> System.out.print(e + " "));

        while (!command.equals("end")){

            switch (command){
                case "add":
                    numbers = addToArray.apply(numbers);

                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);

                    break;
                case "subtract":
                    numbers = subtractFromArray.apply(numbers);
                    break;
                case "print":
                    printArray.accept(numbers);
                    System.out.println();
                    break;
            }



            command = scan.nextLine();
        }
    }
}
