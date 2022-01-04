public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        // O(N) Time Kadane's Algorithm
        int sumSoFar = nums[0], maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            sumSoFar = Math.max(sumSoFar + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sumSoFar);
        }

        return maxSum;
    }

    // O(N^2) Time Algorithm
    public int maxSubArray_naive(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;
    }
}
