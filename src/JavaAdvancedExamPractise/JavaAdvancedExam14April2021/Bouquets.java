package JavaAdvancedExamPractise.JavaAdvancedExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> daffodils = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        List<Integer> tulipsAsList = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer integer : tulipsAsList) {
            tulips.push(integer);
        }

        int wreathsCount = 0;
        int leftOvers = 0;

        while (!daffodils.isEmpty() && !tulips.isEmpty()){

            int currentDaffodil = daffodils.peek();
            int currentTulip = tulips.peek();

            int sum = currentDaffodil + currentTulip;

            if(sum == 15){
                wreathsCount++;
                daffodils.poll();
                tulips.pop();
            }else if(sum > 15){
                tulips.pop();
                tulips.push(currentTulip - 2);
            }else{
                leftOvers+= sum;
                daffodils.poll();
                tulips.pop();
            }
        }
        int leftOverWreaths = leftOvers / 15;

        wreathsCount+= leftOverWreaths;

        if(wreathsCount >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", wreathsCount);
        }else{
            System.out.printf("You failed... You need more %d bouquets.", 5 - wreathsCount);
        }
    }
}
