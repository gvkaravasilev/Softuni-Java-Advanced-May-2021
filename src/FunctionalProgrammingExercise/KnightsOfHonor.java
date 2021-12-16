package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");

        Consumer<String[]> sirPrint = array -> Arrays.stream(array)
                .forEach(e -> System.out.println("Sir " + e));

        sirPrint.accept(tokens);
    }
}
