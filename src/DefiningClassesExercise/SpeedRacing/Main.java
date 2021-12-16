package DefiningClassesExercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            String[] tokens = input.split("\\s+");

            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);


            carList.add(car);
        }

        String input = scan.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            String model = tokens[1];
            double kmAmount = Double.parseDouble(tokens[2]);

            for (Car car : carList) {
                if(car.getModel().equals(model)){
                    car.ableToDrive(model, kmAmount);
                }
            }

            input = scan.nextLine();
        }

        carList.forEach(e -> System.out.println(e.toString()));
    }
}
