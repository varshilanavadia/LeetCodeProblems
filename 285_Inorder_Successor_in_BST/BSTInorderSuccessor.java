public class BSTInorderSuccessor {

    // 285 - Part 1
    /*
    Naive approach
    successor is either on right side or parent
    cannot be left since due to BST
    * */
    TreeNode previous, successor;
    public TreeNode inorderSuccessor_1(TreeNode root, TreeNode target){
        if(target.right != null){
            TreeNode leftMost = target.right;
            while(leftMost.left != null){
                leftMost = leftMost.left;
            }
            this.successor = leftMost;
        } else {
            inorderTraversal(root, target);
        }
        return this.successor;
    }

    private void inorderTraversal(TreeNode node, TreeNode target) {
        if(node == null){
            return;
        }

        inorderTraversal(node.left, target);

        if(this.successor == null && this.previous == target){
            this.successor = node;
            return;
        }

        this.previous = node;

        inorderTraversal(node.right, target);
    }

    // Optimized approach using BST property
    public TreeNode inorderSuccessor_2(TreeNode root, TreeNode target){
        TreeNode successor = null;

        while(root != null){
            if(root.value <= target.value){
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }


    // 510 - Part 2
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node inorderSuccessor(Node node) {
        Node successor = null;
        if(node.right != null){
            Node leftMost = node.right;
            while(leftMost.left != null){
                leftMost = leftMost.left;
            }
            successor = leftMost;
        } else {
            while(node.parent != null && node.parent.right == node){
                node = node.parent;
            }
            successor = node.parent;
        }
        return successor;
    }
}
