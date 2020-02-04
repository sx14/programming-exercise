import java.util.Stack;

public class Q20MinStack1 {
    Stack<Integer> values = new Stack<>();
    Stack<Integer> minValues = new Stack<>();


    public void push(int node) {
        values.push(node);
        if (minValues.empty() || node < minValues.peek()){
            minValues.push(node);
        }

    }

    public void pop() {
        int value = values.pop();
        if (value == minValues.peek()){
            minValues.pop();
        }
    }

    public int top() {
        return values.peek();
    }

    public int min() {
        return minValues.peek();
    }
}
