package SetsAndMapsLab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> cities = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            String[] tokens = input.split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            cities.putIfAbsent(continent, new LinkedHashMap<>());

            LinkedHashMap<String, ArrayList<String>> innerMap = cities.get(continent);

            innerMap.putIfAbsent(country, new ArrayList<>());
            innerMap.get(country).add(city);
        }
        for (var entry : cities.entrySet()) {
            System.out.println(entry.getKey() + ":");

            LinkedHashMap<String, ArrayList<String>> innerMap = entry.getValue();

            for (var innerMapEntrySet : innerMap.entrySet()) {
                System.out.print("  " + innerMapEntrySet.getKey() + " -> ");
                System.out.println(String.join(", ", innerMapEntrySet.getValue()));
            }
        }
    }
}
