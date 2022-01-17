public class NextPerm {
    public int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
        return nums;
    }

    private void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while(start < end){
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
