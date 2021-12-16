package SetsAndMapsLab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> studentsInfo = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsInfo.putIfAbsent(name, new ArrayList<>());
            studentsInfo.get(name).add(grade);
        }
        studentsInfo.entrySet().stream()
                .forEach(entry ->{
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                    double average = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n",average);
                });
    }
}
