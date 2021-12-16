package SetsAndMapsExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] sizeOfSets = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = sizeOfSets[0];
        int m = sizeOfSets[1];

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scan.nextLine());
            secondSet.add(number);
        }
        firstSet.retainAll(secondSet);

        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }
    }
}
