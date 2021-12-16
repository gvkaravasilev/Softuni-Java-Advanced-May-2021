package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersUsingStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int number : numbers) {
            stack.push(number);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
