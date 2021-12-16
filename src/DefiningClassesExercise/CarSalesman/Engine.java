package DefiningClassesExercise.CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }


    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public String setDisplacement(int displacement) {

        String a = "";
        if (this.displacement == 0) {
            a = "n/a";
        }
        return a;
    }

    @Override

    public String toString() {

        if (this.displacement == 0) {
            return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s", model, power, setDisplacement(displacement), efficiency);
        }
        return String.format("%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s", model, power, displacement, efficiency);
    }
}
