package SetsAndMapsLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {

            int firstCardFromFirstDeck = firstDeck.iterator().next();
            int firstCardFromSecondDeck = secondDeck.iterator().next();

            firstDeck.remove(firstCardFromFirstDeck);
            secondDeck.remove(firstCardFromSecondDeck);


            if (firstCardFromFirstDeck > firstCardFromSecondDeck) {

                firstDeck.add(firstCardFromFirstDeck);
                firstDeck.add(firstCardFromSecondDeck);
            } else if (firstCardFromSecondDeck > firstCardFromFirstDeck) {

                secondDeck.add(firstCardFromFirstDeck);
                secondDeck.add(firstCardFromSecondDeck);
            }

        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
