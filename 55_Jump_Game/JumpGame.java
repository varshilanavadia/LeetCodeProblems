public class JumpGame {
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
}
