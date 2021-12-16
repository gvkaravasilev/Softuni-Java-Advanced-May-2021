package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();


            if (command.equals("2")) {
                Integer pop = stack.pop();
            }else if(command.equals("3")){
                System.out.println(getMaxElementFromStack(stack));
            }else if(command.split("\\s+")[0].equals("1")){
                int elementToBePushed = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(elementToBePushed);
            }
        }
    }

    private static int getMaxElementFromStack(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;

        for (Integer integer : stack) {
            if(integer > max){
                max = integer;
            }
        }
        return max;
    }
}
