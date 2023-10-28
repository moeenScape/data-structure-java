public class DoubleLinkList {
    static NodeDouble head;
    static NodeDouble tail;

    public DoubleLinkList() {
        head = null;
        tail = null;
    }

    public void append(int data) {
        NodeDouble nodeDouble = new NodeDouble(data);
        if (head == null) {
            head = nodeDouble;
            tail = nodeDouble;
        } else {
            tail.next = nodeDouble;
            nodeDouble.prev = tail;
            tail = nodeDouble;
        }
    }

    public void displayForward() {
        System.out.println("Forward Travel");
        NodeDouble temp = head;
        while (temp != null) {
            System.out.print("->"+temp.data);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        System.out.println("Backward Travel:");
        NodeDouble temp = tail;
        while (temp!= null) {
            System.out.print("<-" + temp.data);
            temp = temp.prev;
        }
    }
}
