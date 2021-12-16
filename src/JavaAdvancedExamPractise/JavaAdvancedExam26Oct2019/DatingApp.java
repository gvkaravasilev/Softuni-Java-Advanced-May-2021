package JavaAdvancedExamPractise.JavaAdvancedExam26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> malesAsList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> males = new ArrayDeque<>();

        for (Integer integer : malesAsList) {
            males.push(integer);
        }

        ArrayDeque<Integer> females = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matchesCount = 0;

        while (males.size() > 0 && females.size() > 0){

            int currentMale = males.peek();
            int currentFemale = females.peek();


            if(currentMale <= 0 || currentFemale <= 0){
                if(currentMale <= 0){
                    males.pop();
                }
                if(currentFemale <= 0){
                    females.poll();
                }
                continue;
            }

            if(currentFemale % 25 == 0){
                if(females.size() > 1){
                    for (int i = 0; i < 2; i++) {
                        females.poll();
                    }
                }else{
                    females.poll();
                }
                continue;
            }

            if(currentMale % 25 == 0){
                if(males.size() > 1){
                    for (int i = 0; i < 2; i++) {
                        males.pop();
                    }
                }else{
                    males.pop();
                }
                continue;
            }


            if(currentMale == currentFemale){

                males.pop();
                females.poll();
                matchesCount++;
            }else{
                females.poll();
                males.push(males.pop() - 2);
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);
        System.out.println("Males left: " + getInfo(males));
        System.out.println("Females left: " + getInfo(females));
    }

    private static String getInfo(ArrayDeque<Integer> deque) {
        if(deque.isEmpty()){
            return "none";
        }else{
            return deque.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
        }
    }
}
