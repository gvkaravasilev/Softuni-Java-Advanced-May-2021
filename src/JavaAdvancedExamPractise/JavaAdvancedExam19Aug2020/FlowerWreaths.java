package JavaAdvancedExamPractise.JavaAdvancedExam19Aug2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        List<Integer> liliesAsList = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer integer : liliesAsList) {
            lilies.push(integer);
        }

        ArrayDeque<Integer> roses = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));





        int wreathsCount = 0;
        int leftOvers = 0;

        while (!roses.isEmpty() && !lilies.isEmpty()){

            int currentRose = roses.peek();
            int currentLili = lilies.peek();

            int sum = currentRose + currentLili;

            if(sum == 15){
                wreathsCount++;
                lilies.pop();
                roses.poll();

            }else if(sum > 15){
                lilies.pop();
                lilies.push(currentLili - 2);

            }else{
                leftOvers += sum;
                lilies.pop();
                roses.poll();
            }

        }
        if(wreathsCount >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
        }else{
            int wreathFromLeftovers = leftOvers / 15;
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - (wreathsCount + wreathFromLeftovers));
        }
    }
}
