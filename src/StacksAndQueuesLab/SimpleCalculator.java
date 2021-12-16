package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] expression = scan.nextLine().split("\\s+");

        for (int i = expression.length - 1; i >= 0; i--) {
            stack.push(expression[i]);
        }
        while (stack.size() > 1) {
            int rightOperand = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int leftOperand = Integer.parseInt(stack.pop());

            int result = operation.equals("+")
                    ? leftOperand + rightOperand
                    : rightOperand - leftOperand;

            stack.push(String.valueOf(result));
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
