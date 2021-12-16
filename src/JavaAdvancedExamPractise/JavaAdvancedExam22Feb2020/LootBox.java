package JavaAdvancedExamPractise.JavaAdvancedExam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        List<Integer> secondBoxAsList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer integer : secondBoxAsList) {
            secondBox.push(integer);
        }

        int sumOfClaimedItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()){

            int firstItem = firstBox.peek();
            int secondItem = secondBox.peek();

            int sum = firstItem + secondItem;

            if(sum % 2 == 0){
                sumOfClaimedItems += sum;
                firstBox.poll();
                secondBox.pop();
            }else{
                firstBox.offer(secondBox.pop());
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if(secondBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if(sumOfClaimedItems >= 100){
            System.out.printf("Your loot was epic! Value: %d", sumOfClaimedItems );
        }else{
            System.out.printf("Your loot was poor... Value: %d", sumOfClaimedItems);
        }
    }
}
