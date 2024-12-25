import java.util.ArrayList;
import java.util.Arrays;

public class Stack {
    private ArrayList<Object> list;
    
    public Stack() {
        list = new ArrayList<>();
    }
    
    public Stack(Object[] array) {
        list = new ArrayList<>(Arrays.asList(array));
    }
    
    public int getSize() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public Object peek() {
        return list.getLast();
    }
    
    public Object pop() {
        return list.removeLast();
    }
    
    public void push(Object e) {
        list.add(e);
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
}