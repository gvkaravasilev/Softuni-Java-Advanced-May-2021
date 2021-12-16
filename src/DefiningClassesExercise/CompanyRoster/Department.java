package DefiningClassesExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public double getAverageSalary(){
        return this.employeeList
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }


    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String toString(){
        return this.name;
    }

}
