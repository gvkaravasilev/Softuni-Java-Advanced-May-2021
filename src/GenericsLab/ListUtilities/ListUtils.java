package GenericsLab.ListUtilities;

import java.util.List;

public class ListUtils <T>{
    public static <T extends Comparable<T>> T getMax(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException("Collection is empty");
        }

        return list.stream().max(T::compareTo).orElse(null);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException("Collection is empty");
        }

        return list.stream().min(T::compareTo).orElse(null);
    }
}
