package JavaAdvancedExamPractise.JavaAdvancedExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        ArrayDeque<Integer> bombEffects = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();

        List<Integer> bombCasingsAsList = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());



        for (Integer integer : bombCasingsAsList) {
            bombCasings.push(integer);
        }

        LinkedHashMap<Integer, String> bombsTable = new LinkedHashMap<>();

        bombsTable.put(40, "Datura Bombs");
        bombsTable.put(60, "Cherry Bombs");
        bombsTable.put(120, "Smoke Decoy Bombs");


        TreeMap<String, Integer> bombsCount = new TreeMap<>();

        bombsCount.put("Datura Bombs", 0);
        bombsCount.put("Cherry Bombs", 0);
        bombsCount.put("Smoke Decoy Bombs", 0);

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty() && !fulfilledBombPouch(bombsCount) ){

            int currentBombEffect = bombEffects.peek();
            int currentBombCasing = bombCasings.peek();

            int sum = currentBombEffect + currentBombCasing;

            if(ableToBomb(sum)){

                String bomb = bombsTable.get(sum);

                bombsCount.put(bomb, bombsCount.get(bomb) + 1);

                bombEffects.poll();
                bombCasings.pop();


            }else{
                bombCasings.pop();
                bombCasings.push(currentBombCasing - 5);
            }
        }
        if(fulfilledBombPouch(bombsCount)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.println("Bomb Effects: " + getInfo(bombEffects));
        System.out.println("Bomb Casings: " + getInfo(bombCasings));

        bombsCount.forEach((key, value) -> System.out.println(key + ": " + value));


    }

    private static String getInfo(ArrayDeque<Integer> deque) {
        if(deque.isEmpty()){
            return "empty";
        }else{
            return deque.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
        }
    }

    private static boolean fulfilledBombPouch(TreeMap<String, Integer> bombsCount) {
        for (Integer value : bombsCount.values()) {
            if(value < 3){
                return false;
            }
        }
        return true;
    }

    private static boolean ableToBomb(int sum) {
        return sum == 40 || sum == 60 || sum == 120;
    }
}
