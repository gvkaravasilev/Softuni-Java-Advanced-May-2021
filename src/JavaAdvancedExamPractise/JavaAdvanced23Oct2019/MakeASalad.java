package JavaAdvancedExamPractise.JavaAdvanced23Oct2019;

import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> vegetables = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> caloriesList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> calories = new ArrayDeque<>();

        for (Integer integer : caloriesList) {
            calories.push(integer);
        }

        Map<String, Integer> vegetableTable = new LinkedHashMap<>();

        vegetableTable.put("tomato", 80);
        vegetableTable.put("carrot", 136);
        vegetableTable.put("lettuce", 109);
        vegetableTable.put("potato", 215);



        while (!vegetables.isEmpty() && !calories.isEmpty()){

            int currentCalories = calories.peek();

            while (currentCalories > 0 && !vegetables.isEmpty()){
                currentCalories -= vegetableTable.get(vegetables.poll());
            }

            System.out.print(calories.pop() + " ");
        }

        System.out.println();

        if(!calories.isEmpty()){
            while (!calories.isEmpty()){
                System.out.print(calories.pop() + " ");
            }
        }
        if(!vegetables.isEmpty()){
            while (!vegetables.isEmpty()){
                System.out.print(vegetables.poll() + " ");
            }
        }
    }
}
