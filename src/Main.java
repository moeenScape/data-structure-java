import java.util.Scanner;

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


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        LinkList linkList = new LinkList();

        linkList.append(1);
        linkList.append(2);
        linkList.append(3);
        linkList.append(4);
        System.out.print("Initial Value :");
        linkList.display();
        System.out.println();
        if (linkList.getTargetValue(1)) {
            System.out.print("Value Found.");
        } else {
            System.out.print("Value is not present.");
        }
        System.out.println();
        System.out.print("Add ar Start : ");
        linkList.addValueAtStart(100);
        linkList.display();
        System.out.println();
        System.out.print("Add At End :");
        linkList.addValueAtEnd(200);
        linkList.display();
        System.out.println();
        System.out.print("Delete A value : ");
        linkList.deleteNode(200);
        linkList.display();
        System.out.println();
        System.out.print("add nth position :");
        linkList.addValueAtNthPosition(300, 3);
        linkList.display();
        System.out.println();
        System.out.print("Display list After Delete :");
        linkList.deleteNodeAtNthPosition(3);
        linkList.display();

    }
}