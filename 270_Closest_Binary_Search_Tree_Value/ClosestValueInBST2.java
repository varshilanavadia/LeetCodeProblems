import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestValueInBST2 {
    List<Integer> nums;
    double target;
    int k;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.nums = new ArrayList();
        CommonAlgorithms obj = new CommonAlgorithms();
        this.nums = obj.inorderTraversal(root);
//        inorder(root);

        this.target = target;
        this.k = k;

        quickSelect(0, nums.size()-1);

        return this.nums.subList(0, k);

    }

    private void quickSelect(int left, int right){
        if(left >= right) return;

        int pivot = partition(left, right);

        if(pivot == k){
            return;
        }

        if(pivot > k){
            quickSelect(left, pivot-1);
        } else {
            quickSelect(pivot+1, right);
        }
    }

    private int partition(int left, int right){
        int pivotElement = this.nums.get(right);

        int j = left;
        for(int i = left; i < right; i++){
            if(Math.abs(target - this.nums.get(i)) < Math.abs(target - pivotElement)){
                Collections.swap(this.nums, i, j++);
            }
        }
        Collections.swap(this.nums, j, right);
        return j;
    }
}
