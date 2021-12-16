package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command){
                case "1":
                    String textToBePushed = tokens[1];

                    text.append(textToBePushed);
                    stack.push(text.toString());

                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);

                    text = new StringBuilder(text.toString().substring(0 , text.length() - count));

                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);

                    System.out.println(text.toString().charAt(index - 1));

                    break;
                case "4":
                    text = new StringBuilder(stack.pop());
                    break;
            }
        }
    }
}
