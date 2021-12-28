public class Main8 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode297 root = createTree();

        System.out.println(codec.serialize(root));
        System.out.println(codec.deserialize(codec.serialize(root)));
    }

    private static TreeNode297 createTree() {
        TreeNode297 root = new TreeNode297(1);

        root.left = new TreeNode297(2);
        root.right = new TreeNode297(3);

        root.right.left = new TreeNode297(4);
        root.right.right = new TreeNode297(5);

        return root;
    }
}
