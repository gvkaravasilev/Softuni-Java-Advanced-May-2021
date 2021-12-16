package DefiningClassesExercise.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Car car;
        Engine engine;
        Cargo cargo;
        Tyre tyre1;
        Tyre tyre2;
        Tyre tyre3;
        Tyre tyre4;

        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            String[] tokens = input.split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            engine = new Engine(engineSpeed, enginePower);
            cargo = new Cargo(cargoWeight, cargoType);

            tyre1 = new Tyre(tire1Pressure, tire1Age);
            tyre2 = new Tyre(tire2Pressure, tire2Age);
            tyre3 = new Tyre(tire3Pressure, tire3Age);
            tyre4 = new Tyre(tire4Pressure, tire4Age);

            car = new Car(model, engine, cargo, tyre1, tyre2, tyre3, tyre4);
            cars.add(car);
        }

        String command = scan.nextLine();
        List<String> output = new ArrayList<>();

        if(command.equals("fragile")){

            cars.forEach(e -> {
                if(e.getCargo().getCargoType().equals("fragile")){
                    for (Tyre currentTyre : e.getTiresList()) {
                        if(currentTyre.getPressure() < 1){
                            output.add(e.getModel());
                            break;
                        }
                    }
                }
            });



        }else if(command.equals("flamable")){

            cars.forEach(e -> {
                if(e.getCargo().getCargoType().equals("flamable")){
                    if(e.getEngine().getEnginePower() > 250){
                        output.add(e.getModel());
                    }
                }
            });
        }
        output.forEach(System.out::println);
    }
}
