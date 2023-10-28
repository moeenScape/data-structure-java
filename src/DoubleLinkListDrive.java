public class DoubleLinkListDrive {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();

        doubleLinkList.append(10);
        doubleLinkList.append(20);
        doubleLinkList.append(30);

        doubleLinkList.displayForward();
        System.out.println();
        doubleLinkList.displayBackward();
    }
}
