package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String[] tokens = scan.nextLine().split("\\s+");

        Predicate<String> uppercaseChecker = word -> Character.isUpperCase(word.charAt(0));

        List<String> uppercaseWords = new ArrayList<>();

        for (String token : tokens) {
            if(uppercaseChecker.test(token)){
                uppercaseWords.add(token);
            }
        }
        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(System.out::println);
    }
}
