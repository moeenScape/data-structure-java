import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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