package DefiningClassesExercise.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String setWeight(int weight) {
        String a = "";

        if(this.weight == 0){
            a = "n/a";
        }
        return a;
    }

    @Override

    public String toString() {

        if(this.weight == 0){
            return String.format("%s:%n%s%nWeight: %s%nColor: %s", model, engine, setWeight(weight), color);
        }
        return String.format("%s:%n%s%nWeight: %d%nColor: %s", model, engine, weight, color);
    }
}
