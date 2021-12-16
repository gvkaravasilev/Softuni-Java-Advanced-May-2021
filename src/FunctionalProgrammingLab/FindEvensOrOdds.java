package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] tokens = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lowerBound = tokens[0];
        int upperBound = tokens[1];

        String evenOrOdd = scan.nextLine();

        Predicate<Integer> filter = getFilter(evenOrOdd);
        Consumer<Integer> printer = x -> System.out.print(x + " ");

        IntStream
                .rangeClosed(lowerBound, upperBound)
                .boxed()
                .filter(filter)
                .forEach(printer);

    }

    private static Predicate<Integer> getFilter(String evenOrOdd) {
        if(evenOrOdd.equals("odd")){
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }
}
