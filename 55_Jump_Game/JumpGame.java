public class JumpGame {
    // 45 - JUMP GAME 1
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        memo[nums.length-1] = true;
        return helper(nums, 0, memo);
    }

    private boolean helper(int[] nums, int i, Boolean[] memo){
        if(i == nums.length-1){
            return true;
        }

        if(memo[i] != null){
            return memo[i];
        }

        int farthestJump = Math.min(nums.length-1, i + nums[i]);
        for(int j = farthestJump; j > i; j--){
            if(helper(nums, j, memo)){
                memo[i] = true;
                return true;
            }
        }
        return memo[i] = false;
    }

    // 55 JUMP GAME 2
    public int minJump(int[] nums){
        return findMinJump(nums, 0, new Integer[nums.length]);
    }

    private int findMinJump(int[] nums, int index, Integer[] memo) {
        if(index == nums.length-1){
            return 0;
        }

        if(memo[index] != null){
            return memo[index];
        }

        int maxJump = Math.min(nums.length-1, nums[index] + index);
        memo[index] = 10001;
        for (int i = 1; i <= maxJump; i++) {
            memo[index] = Math.min(memo[index], 1 + findMinJump(nums, i, memo));
        }
        return memo[index];
    }
}
