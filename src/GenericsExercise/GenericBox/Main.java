package GenericsExercise.GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Box<Integer>> boxList = new ArrayList<>();

        while(n -- > 0){
            Integer number = Integer.parseInt(scan.nextLine());
            Box<Integer> box = new Box<>(number);
            boxList.add(box);
        }

        boxList.forEach(System.out::println);
    }
}
