package DefiningClassesExercise.RawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyre1;
    private Tyre tyre2;
    private Tyre tyre3;
    private Tyre tyre4;

    public Car(String model, Engine engine, Cargo cargo, Tyre tyre1, Tyre tyre2, Tyre tyre3, Tyre tyre4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyre1 = tyre1;
        this.tyre2 = tyre2;
        this.tyre3 = tyre3;
        this.tyre4 = tyre4;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tyre> getTiresList(){
        return Arrays.asList(tyre1, tyre2, tyre3, tyre4);
    }
}
