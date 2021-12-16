package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        TreeMap<Character, Integer> symbolOccurrences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            symbolOccurrences.putIfAbsent(currentSymbol, 0);
            int currentCount = symbolOccurrences.get(currentSymbol);

            symbolOccurrences.put(currentSymbol, currentCount + 1);
        }
        for (var entry : symbolOccurrences.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(), entry.getValue());
        }
    }
}
