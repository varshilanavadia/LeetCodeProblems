import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    // HOUSE ROOBER 1
    public int rob_1_topDownDP(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return robFrom(nums, memo, 0);
    }

    private int robFrom(int[] nums, int[] memo, int index){
        if(index >= nums.length){
            return 0;
        }

        if(memo[index] > -1){
            return memo[index];
        }

        return memo[index] = Math.max(robFrom(nums, memo, index+1), robFrom(nums, memo, index+2) + nums[index]);
    }

    public int rob_1_bottomUpDP(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        memo[0] = nums[0];
        memo[1] = Math.max(nums[1], nums[0]);

        for(int i = 2; i < n; i++){
            memo[i] = Math.max(nums[i] + memo[i-2], memo[i-1]);
        }

        return memo[n-1];
    }

    // HOUSR ROBBER 2
    public int rob_2(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int robFromFirst = robFromHouse(nums, 0, nums.length-2);
        int robFromSecond = robFromHouse(nums, 1, nums.length-1);

        return Math.max(robFromFirst, robFromSecond);
    }

    private int robFromHouse(int[] nums, int left, int right){
        int r1 = 0, r2 = 0;
        for(int i = left; i <= right; i++){
            int temp = r1;
            r1 = Math.max(r1, r2 + nums[i]);
            r2 = temp;
        }
        return r1;
    }

    // HOUSE ROBBER 3
    public int rob_3_recursion(TreeNode root) {
        int[] result = helper1(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper1(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }

        int[] left = helper1(node.left);
        int[] right = helper1(node.right);

        int rob = node.value + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }

    public int rob_3_memoization(TreeNode root) {
        HashMap<TreeNode, Integer> robbed = new HashMap<>();
        HashMap<TreeNode, Integer> notRobbed = new HashMap<>();
        return helper2(root, false, robbed, notRobbed);
    }

    private int helper2(TreeNode node, boolean parentRobbed, Map<TreeNode, Integer> robbed, Map<TreeNode, Integer> notRobbed){
        if(node == null){
            return 0;
        }

        if(parentRobbed){
            if(robbed.containsKey(node)){
                return robbed.get(node);
            }
            int result = helper2(node.left, false, robbed, notRobbed) + helper2(node.right, false, robbed, notRobbed);
            robbed.put(node, result);
            return result;

        } else {
            if(notRobbed.containsKey(node)){
                return notRobbed.get(node);
            }

            int rob = node.value + helper2(node.left, true, robbed, notRobbed) + helper2(node.right, true, robbed, notRobbed);
            int notRob = helper2(node.left, false, robbed, notRobbed) + helper2(node.right, false, robbed, notRobbed);
            notRobbed.put(node, Math.max(rob, notRob));
            return Math.max(rob, notRob);
        }
    }
}
