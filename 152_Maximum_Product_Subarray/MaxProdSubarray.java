public class MaxProdSubarray {
    // O(N) time Kadane's Algorithm based
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxProduct = maxSoFar;

        for(int i = 1; i < nums.length; i++){
            int temp = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
            minSoFar = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));
            maxSoFar = temp;
            maxProduct = Math.max(maxSoFar, maxProduct);
        }

        return maxProduct;
    }

    // O(N^2) Time Naive Algorithm
    public int maxProduct_naive(int[] nums){
        if(nums.length == 0) return 0;

        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currProduct = 1;
            for (int j = i; j < nums.length; j++) {
                currProduct *= nums[j];
                result = Math.max(result, currProduct);
            }
        }
        return result;
    }
}
