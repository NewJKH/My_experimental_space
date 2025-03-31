package generic.single;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public void set(T v){
        this.value = v;
    }

    public T getValue() {
        return value;
    }
}
