package GenericsLab.Jar;

import java.util.ArrayDeque;

public class Jar <T>{

    private ArrayDeque<T> stack;

    public void add(T element){
        stack.push(element);
    }

    public T remove(){
        return stack.pop();
    }
}
