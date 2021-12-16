package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int currentNumber = scan.nextInt();
            stack.push(currentNumber);
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if(stack.isEmpty()){
            System.out.println(0);
        }else{
            if(stack.contains(x)){
                System.out.println("true");
            }else{
                System.out.println(getMinElementFromStack(stack));
            }
        }
    }

    private static int getMinElementFromStack(ArrayDeque<Integer> stack) {
        int min = Integer.MAX_VALUE;

        for (Integer integer : stack) {
            if(integer < min){
                min = integer;
            }
        }
        return min;
    }
}
