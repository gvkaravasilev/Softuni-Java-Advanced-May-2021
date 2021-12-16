package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] tokens = scan.nextLine().split("\\s+");

        Predicate<String> lessOrEqualLength = word -> word.length() <= n;

        Arrays.stream(tokens)
                .filter(lessOrEqualLength)
                .forEach(System.out::println);


    }
}
