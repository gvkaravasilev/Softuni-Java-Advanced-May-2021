package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        LinkedHashSet<String> words = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            words.add(word);
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
