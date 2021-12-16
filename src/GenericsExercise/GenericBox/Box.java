package GenericsExercise.GenericBox;

import java.util.List;

public class Box <T extends Comparable<T>>{
    private T value;

    public Box(T value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value.getClass().getName()
                + ": " + value;
    }
}
