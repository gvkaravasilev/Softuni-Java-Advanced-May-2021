package JavaAdvancedExamPractise.JavaAdvancedExam16Dec2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();



        List<Integer> ingredientsAsList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer integer : ingredientsAsList) {
            ingredients.push(integer);
        }

        Map<Integer, String> cookingTable = new HashMap<>();

        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        TreeMap<String, Integer> cookedMeals = new TreeMap<>();

        cookedMeals.put("Bread", 0);
        cookedMeals.put("Cake", 0);
        cookedMeals.put("Pastry", 0);
        cookedMeals.put("Fruit Pie", 0);


        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();

            int sum = currentLiquid + currentIngredient;

            if (ableToCook(sum)) {

                String product = cookingTable.get(sum);

                cookedMeals.put(product, cookedMeals.get(product) + 1);

            } else {
                ingredients.push(currentIngredient + 3);
            }
        }
        if(cookedEachMeal(cookedMeals)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }


        System.out.println("Liquids left: " + getInfo(liquids));
        System.out.println("Ingredients left: " + getInfo(ingredients));
        



        for (Map.Entry<String, Integer> stringIntegerEntry : cookedMeals.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }
    }

    private static String getInfo(ArrayDeque<Integer> deque) {

        if(deque.isEmpty()){
            return "none";
        }
        return deque.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static boolean cookedEachMeal(TreeMap<String, Integer> cookedMeals) {
        for (Integer value : cookedMeals.values()) {
            if(value == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean ableToCook(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}
