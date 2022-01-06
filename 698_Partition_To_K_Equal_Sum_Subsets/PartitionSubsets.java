import java.util.stream.IntStream;

public class PartitionSubsets {

    // O(k 2^N) Time Solution
    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int arraySum = IntStream.of(nums).sum();

        if(k == 0 || arraySum % k != 0){
            return false;
        }

        return canPartition(nums, k, 0, arraySum/k, new boolean[nums.length], 0)  ;
    }

    private boolean canPartition(int[] nums, int k, int index, int targetSum, boolean[] used, int currentSum){
        if(k == 1){
            return true;
        }

        if(currentSum > targetSum){
            return false;
        }

        if(currentSum == targetSum){
            return canPartition(nums, k-1, 0, targetSum, used, 0);
        }

        for(int i = index; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                if(canPartition(nums, k, i+1, targetSum, used, currentSum + nums[i])){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }


    // 416 - Partition Equal Subset Sum
    public boolean canPartition(int[] nums) {
        int total = IntStream.of(nums).sum();

        if(total % 2 != 0) return false;

        int target = total/2;
        Boolean[][] memo = new Boolean[nums.length + 1][target + 1];

        return backtrack(nums, target, nums.length-1, memo);
    }

    private boolean backtrack(int[] nums, int target, int index, Boolean[][] memo){
        if(target == 0){
            return true;
        }

        if(index <= 0 || target < 0){
            return false;
        }

        if(memo[index][target] != null){
            return memo[index][target];
        }

        return memo[index][target] = backtrack(nums, target - nums[index], index-1, memo) || backtrack(nums, target, index-1, memo);
    }

}
