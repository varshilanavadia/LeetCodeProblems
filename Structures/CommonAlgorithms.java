import java.util.*;

public class CommonAlgorithms {

    /*
    * DIFFERENT VERSIONS OF BINARY SEARCH
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
    * HEIGHT OF BINARY TREE
    * */

    public int heightOfBT(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = heightOfBT(node.left);
        int rightHeight = heightOfBT(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
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

    /*
    * QUICK SORT ALGORITHM
    * */
    public int[] quickSort(int[] nums){
        quickSortHelper(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSortHelper(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }

        int pivot = partition(nums, left, right);
        quickSortHelper(nums, left, pivot - 1);
        quickSortHelper(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = right;
        int i = left;
        for (int j = left; j < right; j++) {
            if(nums[j] < nums[pivot]){
                swap(nums, j, i++);
            }
        }
        swap(nums, pivot, i);
        return i;
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        CommonAlgorithms a = new CommonAlgorithms();
        System.out.println(Arrays.toString(a.quickSort(new int[]{3, 5, 1, 2, 7, 6, 4})));
    }
}
