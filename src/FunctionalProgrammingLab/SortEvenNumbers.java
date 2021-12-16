package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();


        String evenNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        String sortedNumbers = Arrays.stream(numbers)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));


        System.out.println(evenNumbers);
        System.out.println(sortedNumbers);


    }
}
