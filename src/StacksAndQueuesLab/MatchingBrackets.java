package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String expression = scan.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if(currentChar == '('){
                stack.push(i);
            }else if(currentChar == ')'){
                int startIndex = stack.pop();
                String parts = expression.substring(startIndex, i + 1);
                System.out.println(parts);
            }
        }
    }
}
