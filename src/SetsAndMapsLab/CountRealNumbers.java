package SetsAndMapsLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numberOccurrences = new LinkedHashMap<>();

        double[] numbersInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number : numbersInput) {
            numberOccurrences.putIfAbsent(number, 0);

            numberOccurrences.put(number, numberOccurrences.get(number) + 1);
        }
        numberOccurrences.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
