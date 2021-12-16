package SetsAndMapsExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        TreeSet<String> chemicalCompounds = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            chemicalCompounds.addAll(Arrays.asList(input));
        }
        for (String chemicalCompound : chemicalCompounds) {
            System.out.print(chemicalCompound + " ");
        }
    }
}
