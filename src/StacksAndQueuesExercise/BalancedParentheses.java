package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openingBrackets.push(currentSymbol);
            } else if(currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']'){
                if(openingBrackets.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingBrackets.pop();

                if(lastOpeningBracket == '(' && currentSymbol == ')'){
                    areBalanced = true;
                }else if(lastOpeningBracket == '{' && currentSymbol == '}'){
                    areBalanced = true;
                }else if(lastOpeningBracket == '[' && currentSymbol == ']'){
                    areBalanced = true;
                }else{
                    areBalanced = false;
                    break;
                }
            }
        }
        if(areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
