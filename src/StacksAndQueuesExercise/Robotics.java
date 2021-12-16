package StacksAndQueuesExercise;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] robotsData = input.split(";");
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> robotAndWorkingTime = new LinkedHashMap<>();

        ArrayDeque<String> products = new ArrayDeque<>();

        String startTime = scan.nextLine();

        int startTimeInSeconds = getTimeInSeconds(startTime);
        String product = scan.nextLine();

        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            int processTime = Integer.parseInt(robotData.split("-")[1]);
            robots.put(robotName, processTime);
        }

        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            robotAndWorkingTime.put(robotName, 0);
        }



        while (!product.equals("End")) {

            products.offer(product);

            product = scan.nextLine();
        }


        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;

            for (Map.Entry<String, Integer> robot : robotAndWorkingTime.entrySet()) {
                if(robot.getValue() > 0){
                    robotAndWorkingTime.put(robot.getKey(), robot.getValue() - 1);
                }
            }

            boolean isTaken = false;
            for (Map.Entry<String, Integer> robot : robotAndWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {
                    System.out.printf("%s - %s %s%n", robot.getKey(), currentProduct, getStartTime(startTimeInSeconds));
                    robotAndWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct);
            }
        }
    }

    public static int getTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);

        return hours * 3600 + minutes * 60 + seconds;

    }

    public static String getStartTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = (startTimeInSeconds % 3600) / 60;
        int seconds = startTimeInSeconds % 60;


        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }
}
