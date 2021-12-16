package SetsAndMapsLab;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String guestsInput = scan.nextLine();

        TreeSet<String> vipGuests = new TreeSet<>();
        TreeSet<String> regularGuests = new TreeSet<>();

        while (!guestsInput.equals("PARTY")) {

            if (Character.isDigit(guestsInput.charAt(0))) {
                vipGuests.add(guestsInput);
            } else {
                regularGuests.add(guestsInput);
            }
            guestsInput = scan.nextLine();
        }

        guestsInput = scan.nextLine();

        while (!guestsInput.equals("END")) {

            if (Character.isDigit(guestsInput.charAt(0))) {
                vipGuests.remove(guestsInput);
            } else {
                regularGuests.remove(guestsInput);
            }

            guestsInput = scan.nextLine();
        }
        System.out.println(vipGuests.size() + regularGuests.size());
        if (!vipGuests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vipGuests));

        }
        if (!regularGuests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regularGuests));
        }
    }
}
