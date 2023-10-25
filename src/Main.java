class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkList {
    Node head;

    public LinkList() {
        head = null;
    }

    public void append(int data) {
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


public class Main {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        linkList.append(2);
        linkList.append(3);
        linkList.append(4);
        System.out.print("Display list :");
        linkList.display();
        System.out.println();
        if (linkList.getTargetValue(5)) {
            System.out.print("Value Found.");
        } else {
            System.out.print("Value is not present.");
        }
    }
}