package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int currentElement = scan.nextInt();
            queue.offer(currentElement);
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if(queue.isEmpty()){
            System.out.println(0);
        }else{
            if(queue.contains(x)){
                System.out.println("true");
            }else{
                System.out.println(getMinElementFromQueue(queue));
            }
        }
    }

    private static int getMinElementFromQueue(ArrayDeque<Integer> queue) {
        int min = Integer.MAX_VALUE;

        for (Integer integer : queue) {
            if(integer < min){
                min = integer;
            }
        }
        return min;
    }
}
