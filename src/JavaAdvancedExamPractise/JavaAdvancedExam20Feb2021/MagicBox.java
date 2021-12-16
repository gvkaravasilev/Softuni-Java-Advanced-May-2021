package JavaAdvancedExamPractise.JavaAdvancedExam20Feb2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> secondBoxAsList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        for (Integer integer : secondBoxAsList) {
            secondBox.push(integer);
        }

        int claimedItemsSum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()){

            int firstItem = firstBox.peek();
            int secondItem = secondBox.peek();

            int sum = firstItem + secondItem;

            if(sum % 2 == 0){
                claimedItemsSum += sum;
                firstBox.poll();
                secondBox.pop();
            }else{
                firstBox.offer(secondBox.pop());
            }
        }

        if(firstBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if(secondBox.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if(claimedItemsSum >= 90){
            System.out.println("Wow, your prey was epic! Value: " + claimedItemsSum);
        }else{
            System.out.println("Poor prey... Value: " + claimedItemsSum);
        }
    }
}
