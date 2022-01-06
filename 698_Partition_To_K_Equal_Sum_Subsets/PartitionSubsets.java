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



}
