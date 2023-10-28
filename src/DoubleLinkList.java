import java.net.StandardSocketOptions;

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

    public void addAtFirst(int data) {
        NodeDouble nodeDouble = new NodeDouble(data);

        if (head == null) {
            head = nodeDouble;
            tail = nodeDouble;
        } else {
            nodeDouble.next = head;
            head.prev = nodeDouble.next;
            head = nodeDouble;
        }
    }

    public void addAtEnd(int data) {
        NodeDouble nodeDouble = new NodeDouble(data);

        if (head == null) {
            head = nodeDouble;
            tail = nodeDouble;
        } else {
            nodeDouble.prev = tail;
            tail.next =nodeDouble;
            tail = nodeDouble;
        }
    }

    public void displayForward() {
        System.out.print("Forward Travel");
        NodeDouble temp = head;
        while (temp != null) {
            System.out.print("->" + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("Backward Travel:");
        NodeDouble temp = tail;
        while (temp != null) {
            System.out.print("<-" + temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }
}
