package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");

        Consumer<String[]> printNames = array ->
                Arrays.stream(array).forEach(System.out::println);

        printNames.accept(tokens);
    }
}
