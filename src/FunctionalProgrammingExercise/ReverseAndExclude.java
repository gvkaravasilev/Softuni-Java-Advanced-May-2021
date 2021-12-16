package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());

        Predicate<Integer> divisibleOfN = number -> number % n == 0;

        numbers.removeIf(divisibleOfN);

        Collections.reverse(numbers);

        Consumer<List<Integer>> printList = list ->
                list.forEach(e -> System.out.print(e + " "));

        printList.accept(numbers);
    }
}
