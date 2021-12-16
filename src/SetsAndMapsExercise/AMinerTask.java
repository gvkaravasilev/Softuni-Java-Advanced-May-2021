package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String resource = scan.nextLine();

        LinkedHashMap<String, Integer> resourcesAndQuantity = new LinkedHashMap<>();

        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(scan.nextLine());

            resourcesAndQuantity.putIfAbsent(resource, 0);
            resourcesAndQuantity.put(resource, resourcesAndQuantity.get(resource) + quantity);

            resource = scan.nextLine();
        }
        for (var entry : resourcesAndQuantity.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
