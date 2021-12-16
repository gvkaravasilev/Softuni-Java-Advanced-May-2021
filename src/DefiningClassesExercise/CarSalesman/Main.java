package DefiningClassesExercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Engine engine = null;
        Car car = null;

        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();

        while (n-- > 0){
            String input = scan.nextLine();

            String[] tokens = input.split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if(tokens.length == 4){
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }else if(tokens.length == 3){
                if(Character.isDigit(tokens[2].charAt(0))){
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                }else{
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }else{
                engine = new Engine(model, power);
            }
            engineList.add(engine);
        }

        int m = Integer.parseInt(scan.nextLine());

        while (m-- > 0){
            String input = scan.nextLine();

            String[] tokens = input.split("\\s+");

            String model = tokens[0];
            String engineName = tokens[1];

            for (Engine currentEngine : engineList) {
                if(currentEngine.getModel().equals(engineName)){
                    engine = currentEngine;
                    break;
                }
            }

            if(tokens.length == 4){
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            }else if(tokens.length == 3){
                if(Character.isDigit(tokens[2].charAt(0))){
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                }else{
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            }else{
                car = new Car(model, engine);
            }

            carList.add(car);
        }
        for (Car currentCar : carList) {
            System.out.println(currentCar);
        }
    }
}
