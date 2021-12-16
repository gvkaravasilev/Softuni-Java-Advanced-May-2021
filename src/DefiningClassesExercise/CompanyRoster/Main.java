package DefiningClassesExercise.CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Department> departmentMap = new HashMap<>();

        for (int i = 0; i < n; i++) {


            String input = scan.nextLine();

            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;

            if(tokens.length == 6){
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);

            }else if(tokens.length == 5){
                if(tokens[4].contains("@")){
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department,email );
                }else{
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            }else if(tokens.length == 4){
                 employee = new Employee(name, salary, position, department);
            }
            departmentMap.putIfAbsent(department, new Department(department));

            departmentMap.get(department).getEmployeeList().add(employee);
        }

        Department getMaxAverageSalary = departmentMap.
                entrySet().stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + getMaxAverageSalary);

        getMaxAverageSalary.getEmployeeList()
                .stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
