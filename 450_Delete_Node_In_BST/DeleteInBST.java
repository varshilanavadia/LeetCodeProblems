public class DeleteInBST {
    private int successor(TreeNode node){
        node = node.right;
        while(node.left != null){
            node = node.left;
        }
        return node.value;
    }

    private int predecessor(TreeNode node){
        node = node.left;
        while(node.right != null){
            node = node.right;
        }
        return node.value;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(key > root.value){
            root.right = deleteNode(root.right, key);
        } else if (key < root.value){
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null && root.right == null){
                root = null;
            } else if(root.right != null){
                root.value = successor(root);
                root.right = deleteNode(root.right, root.value);
            } else {
                root.value = predecessor(root);
                root.left = deleteNode(root.left, root.value);
            }
        }
        return root;
    }
}
