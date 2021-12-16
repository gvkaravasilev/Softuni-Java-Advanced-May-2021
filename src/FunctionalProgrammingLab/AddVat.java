package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<String, Double> mapperWithVat =
                stream -> Double.parseDouble(stream) * 1.2;

        List<Double> values = Arrays.stream(scan.nextLine().split(", "))
                .map(mapperWithVat)
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");
        values.forEach(value -> System.out.printf("%.2f%n", value));

    }
}
