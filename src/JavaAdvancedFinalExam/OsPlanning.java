package JavaAdvancedFinalExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        List<Integer> tasksAsList = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer integer : tasksAsList) {
            tasks.push(integer);
        }

        ArrayDeque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int taskToKill = Integer.parseInt(scan.nextLine());
        int threadKilledTheTask = 0;


        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int currentTask = tasks.peek();
            int currentThread = threads.peek();

            if (currentTask == taskToKill) {
                threadKilledTheTask = currentThread;
                break;
            }

            if (currentThread >= currentTask) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }


        }
        System.out.printf("Thread with value %d killed task %d%n", threadKilledTheTask, taskToKill);

        while (!threads.isEmpty()){
            System.out.print(threads.pop() + " ");
        }
    }
}
