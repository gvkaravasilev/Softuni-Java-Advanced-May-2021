package SetsAndMapsLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> storeInformation = new TreeMap<>();

        String input = scan.nextLine();

        while (!input.equals("Revision")) {

            String[] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            storeInformation.putIfAbsent(shop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> innerMap = storeInformation.get(shop);
            innerMap.put(product, price);

            input = scan.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> stringLinkedHashMapEntry : storeInformation.entrySet()) {
            String key = stringLinkedHashMapEntry.getKey();

            LinkedHashMap<String, Double> innerMap = stringLinkedHashMapEntry.getValue();

            System.out.println(key + "->");

            for (Map.Entry<String, Double> stringDoubleEntry : innerMap.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
            }
        }
    }
}
