public class Main8 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = createTree();

        System.out.println(codec.serialize(root));
        System.out.println(codec.deserialize(codec.serialize(root)));
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        return root;
    }
}
