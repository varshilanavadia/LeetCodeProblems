import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargestUsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(k);

        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }

    public int findKthLargestUsingQuickSelect(int[] nums, int k) {
        return quickSelect(nums, k-1, 0, nums.length-1);
    }

    private int quickSelect(int[] nums, int k, int left, int right){
        if(left > right)
            return -1;

        int pivot = partition(nums, left, right);

        if(pivot == k){
            return nums[pivot];
        } else if(pivot < k){
            return quickSelect(nums, k, pivot + 1, right);
        } else {
            return quickSelect(nums, k, left, pivot - 1);
        }
    }

    private int partition(int[] nums, int left, int right){
        int pivotIndex = right;
        int i = left;

        for(int j = left; j < right; j++){
            if(nums[j] > nums[pivotIndex]){
                swap(nums, i++, j);
            }
        }
        swap(nums, i, pivotIndex);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
