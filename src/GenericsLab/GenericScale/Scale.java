package GenericsLab.GenericScale;

public class Scale <T extends Comparable<T>>{
    private T left;
    private T right;

    public Scale(T left, T right){
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    public T getHeavier(){
        int result = left.compareTo(right);

        if(result > 0){
            return left;
        }else if(result == 0){
            return null;
        }

        return right;
    }
}
