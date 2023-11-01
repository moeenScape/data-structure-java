public class LinkList {
    static Node head;

    public LinkList() {
        head = null;
    }

    public static void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println();
    }

    public void addValueAtStart(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        head = newNode;
        head.next = temp;
    }

    public void addValueAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void deleteNode(int key) {
        if (key == head.data) {
            head = head.next;
        } else {
            Node temp = head;

            while (temp.next != null) {
                if (temp.next.data == key) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void addValueAtNthPosition(int key, int position) {
        Node newNode = new Node(key);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Position is out of bounds.");
                return;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteNodeAtNthPosition(int position) {
        if (head == null) {
            return;
        }
        if (position == 1) {
            head = head.next;
        } else {
            Node current = head;
            int count = 1;
            while (current != null && count != position - 1) {
                current = current.next;
                count++;
            }
            assert current != null;
            current.next = current.next.next;
        }
    }


    public boolean getTargetValue(int key) {
        if (head.data == key) {
            return true;
        } else {
            Node current = head;

            while (current.next != null) {
                if (current.data == key) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }
}
