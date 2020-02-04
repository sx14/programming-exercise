import java.util.Stack;

public class Q20MinStack {
    Stack<Integer> values = new Stack<>();
    int minValue = Integer.MAX_VALUE;


    public void push(int node) {
        minValue = node < minValue ? node : minValue;
        values.push(node);
    }

    public void pop() {
        int top = values.pop();
        if (top == minValue){
            Stack<Integer> temp = new Stack<>();
            minValue = Integer.MAX_VALUE;
            while (!values.empty()){
                int value = values.pop();
                minValue = value < minValue? value:minValue;
                temp.push(value);
            }
            while (!temp.empty()){
                values.push(temp.pop());
            }
        }
    }

    public int top() {
        return values.peek();
    }

    public int min() {
        return minValue;
    }
}
