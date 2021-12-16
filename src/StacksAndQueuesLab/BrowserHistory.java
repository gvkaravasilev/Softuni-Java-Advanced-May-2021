package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        String currentUrl = "";

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (!command.equals("Home")) {


            if (!command.equals("back")) {
                browserHistory.push(currentUrl);
                currentUrl = command;
            } else {
                if (browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                    command = scan.nextLine();
                    continue;
                } else {
                    currentUrl = browserHistory.pop();
                }
            }
            System.out.println(currentUrl);
            command = scan.nextLine();
        }
    }
}
