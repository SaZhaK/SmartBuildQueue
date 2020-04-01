import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Train> elements;
    private int top;

    public Stack() {
        elements = new ArrayList<>();
        top = -1;
    }

    public void push(Train element) {
        elements.add(element);
        ++top;
    }

    public Train pop() {
        return elements.remove(top--);
    }

    public Train peek() {
        return elements.get(top);
    }

    public Train get(int idx) {
        return elements.get(idx);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return top == -1;
    }
}