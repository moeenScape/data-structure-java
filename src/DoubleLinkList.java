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
            tail.next = nodeDouble;
            tail = nodeDouble;
        }
    }
    public void addValueAtKthPosition(int position, int key) {
        NodeDouble newNode = new NodeDouble(key);
        if (position == 1) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            NodeDouble current = head;
            int count = 1;
            while (count < position - 1 && current != null) {
                current = current.next;
                count++;
            }
            if (current == null) {
                // Position is out of bounds, you can handle this case as needed.
                return;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }

    public boolean searchValue(int key) {
        NodeDouble nodeDouble = head;
        NodeDouble nodeDouble1 = tail;

        while (nodeDouble.next == nodeDouble1.prev) {
            if (nodeDouble.data == key || nodeDouble1.data == key) {
                return true;
            }
            nodeDouble = nodeDouble.next;
            nodeDouble1 = nodeDouble.prev;

        }
        return false;
    }

    public void deleteNode(int key) {

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
