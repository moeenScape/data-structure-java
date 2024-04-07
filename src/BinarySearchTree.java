public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int value) {
        root = new Node(value);
    }

    void insert(int key) {
        root = insert(root, key);
    }

    Node insert(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        }
        if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    Node search(Node root, int value) {
        if (root == null || root.key == value) {
            return root;
        }
        if (root.key < value) {
            return search(root.right, value);
        }
        return search(root.left, value);
    }

    Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        // Recursive calls for ancestors of
        // node to be deleted
        if (root.key < value) {
            root.right = deleteNode(root.right, value);
            return root;
        }
        if (root.key > value) {
            root.left = deleteNode(root.left, value);
            return root;
        }

        // We reach here when root is the node
        // to be deleted.

        // If one of the children is empty

        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }

//        IF Both Child Exist
        else {
            Node succParent = root;

            Node succ = root.right;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            // Delete successor.  Since successor is always left child of its parent
            // we can safely make successor's right.right child as left of its parent.
            // If there is no succ, then assign succ.right to succParent.right

            if (succParent != root) {
                succParent.left = succ.right;
            } else {
                succParent.right = succ.right;
            }
            root.key = succ.key;

            return root;
        }

    }

    void inOrder() {
        inorderRec(root);
    }

    void postOrder() {
        postorderRec(root);
    }

    void preOrder() {
        preorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " -->");
            inorderRec(root.right);
        }
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " -->");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " -->");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Pre Order Travel: ");
        tree.preOrder();
        System.out.println();
        System.out.print("In Order Travel: ");
        tree.inOrder();
        System.out.println();
        System.out.print("Post Order Travel: ");
        tree.postOrder();
        if (tree.search(tree.root, 200) != null) {
            System.out.println("Found Value");
        } else {
            System.out.println("Not Found");
        }

        tree.deleteNode(tree.root, 30);
        System.out.print("In Order Travel After Delete: ");
        tree.inOrder();
    }
}
