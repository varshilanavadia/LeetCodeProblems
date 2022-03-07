import java.util.*;

public class kSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int start){
        List<List<Integer>> result = new ArrayList<>();

        if(start >= nums.length){
            return result;
        }

        if(k == 2){
            return twoSum(nums, target, start);
        }

        for(int i = start; i < nums.length; i++){
            if(i == start || nums[i-1] != nums[i]){
                for(List<Integer> subset: kSum(nums, target-nums[i], k-1, i+1)){
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size()-1).addAll(subset);
                }
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> result = new ArrayList<>();
        int left = start, right = nums.length-1;

        while(left < right){
            int curr = nums[left] + nums[right];
            if(curr < target || (left > start && nums[left] == nums[left-1])){
                left++;
            } else if (curr > target || (right < nums.length-1 && nums[right] == nums[right+1])){
                right--;
            } else {
                result.add(Arrays.asList(nums[left++], nums[right--]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        kSum obj = new kSum();
        System.out.println(obj.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(obj.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(obj.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
    }
}
