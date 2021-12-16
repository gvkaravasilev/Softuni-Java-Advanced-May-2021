package DefiningClassesExercise.OpinionPoll;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());


        TreeMap<String, Integer> personAndAge = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            OpinionPoll opinionPoll = new OpinionPoll(name, age);

            personAndAge.put(opinionPoll.getName(), opinionPoll.getAge());

        }


        personAndAge.entrySet().stream()
                .filter(e -> e.getValue() > 30)
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));

    }
}

