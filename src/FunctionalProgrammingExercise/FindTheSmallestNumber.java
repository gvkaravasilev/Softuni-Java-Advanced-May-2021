package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallestNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> findTheSmallestNumber = list -> {
          int min = Integer.MAX_VALUE;

            for (Integer integer : list) {
                if(integer < min){
                    min = integer;
                }
            }
            System.out.println(list.lastIndexOf(min));
        };

        findTheSmallestNumber.accept(numbers);
    }
}
