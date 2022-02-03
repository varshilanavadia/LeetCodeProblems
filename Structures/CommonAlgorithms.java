import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CommonAlgorithms {

    /*
    * DIFFERENT BINARY SEARCH
    *   1. CLASSIC BINARY SEARCH
    *   2. FIND FIRST INDEX OF TARGET
    *   3. FIND LAST INDEX OF TARGET
    *   4. FIND CEIL OF TARGET
    *   5. FIND FLOOR OF TARGET
    * */
    public int binarySearch(int[] array, int target){
        int left = 0, right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == target){
                return mid;
            } else if(array[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int firstIndex(int[] array, int target){
        int left = 0, right = array.length - 1, result = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == target){
                result = mid;
                right = mid - 1;
            } else if(array[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public int lastIndex(int[] array, int target){
        int left = 0, right = array.length - 1, result = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == target){
                result = mid;
                left = mid + 1;
            } else if(array[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public int ceil(int[] array, int target){
        int left = 0, right = array.length - 1, result = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] >= target){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public int floor(int[] array, int target){
        int left = 0, right = array.length - 1, result = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] <= target){
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /*
    * LEVEL ORDER TRAVERSAL OF BINARY TREE - BREADTH FIRST SEARCH
    * */
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty() ) {
            levels.add(new ArrayList<Integer>());

            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                levels.get(level).add(node.value);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }


    /*
    * INORDER TRAVERSAL OF BINARY TREE - DEPTH FIRST SEARCH
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    public void inorderHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderHelper(root.left, res);
            res.add(root.value);
            inorderHelper(root.right, res);
        }
    }


    /*
     * PREORDER TRAVERSAL OF BINARY TREE - DEPTH FIRST SEARCH
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    public void preorderHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.value);
            preorderHelper(root.left, res);
            preorderHelper(root.right, res);
        }
    }


    /*
     * POSTORDER TRAVERSAL OF BINARY TREE - DEPTH FIRST SEARCH
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    public void postorderHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            postorderHelper(root.left, res);
            postorderHelper(root.right, res);
            res.add(root.value);
        }
    }


    /*
    * CREATE LINKED LIST FROM AN INT[]
    * */
    public ListNode createLinkedList(int[] array) {
        int i = 0;
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(i < array.length){
            dummy.next = new ListNode(array[i++]);
            dummy = dummy.next;
        }
        return head.next;
    }
}
