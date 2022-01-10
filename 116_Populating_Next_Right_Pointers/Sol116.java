public class Sol116 {
    public static void main(String[] args) {
        NextPointer nextPointer = new NextPointer();

        NextPointer.Node root = createTree();

        System.out.println(nextPointer.connect(root));
        // Need to write separate traversal to show level order.

    }

    private static NextPointer.Node createTree() {
        NextPointer.Node root = new NextPointer.Node(1);

        root.left = new NextPointer.Node(2);
        root.right = new NextPointer.Node(3);

        root.left.left = new NextPointer.Node(4);
        root.left.right = new NextPointer.Node(5);

        root.right.left = new NextPointer.Node(6);
        root.right.right = new NextPointer.Node(7);

        return root;
    }
}
