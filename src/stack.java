public class stack {
    private final int SIZE;
    private int top;
    private final int[] arr;

    public stack(int size) {
        SIZE = size;
        arr = new int[SIZE];
        top = -1;
    }

    public void push(int val) {
        if (top == SIZE - 1) {
            System.out.println("Stack is Full");
        } else {
            ++top;
            arr[top] = val;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return arr[top--];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Stack Elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        stack myStack = new stack(5);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("Stack before pop:");
        myStack.display();

        int poppedValue = myStack.pop();
        if (poppedValue != -1) {
            System.out.println("Popped element: " + poppedValue);
        }

        System.out.println("Stack after pop:");
        myStack.display();
    }
}
