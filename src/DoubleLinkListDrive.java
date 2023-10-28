public class DoubleLinkListDrive {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();

        doubleLinkList.append(10);
        doubleLinkList.append(20);
        doubleLinkList.append(30);

        doubleLinkList.displayForward();
        doubleLinkList.displayBackward();
        doubleLinkList.addAtFirst(5);
        doubleLinkList.displayForward();
        doubleLinkList.addAtEnd(40);
        doubleLinkList.displayForward();
    }
}
