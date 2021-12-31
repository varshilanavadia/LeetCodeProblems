import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Two Sum 1
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return null;
    }

    // Two Sum 2
    public int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while(i < j){
            if(nums[i] + nums[j] > target){
                j--;
            } else if(nums[i] + nums[j] < target){
                i++;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return null;
    }

    // Two Sum 3
    Map<Integer, Integer> map;
    public TwoSum() {
        this.map = new HashMap();
    }

    public java.lang.Integer add(int number) {
        this.map.putIfAbsent(number, 0);
        this.map.replace(number, this.map.get(number) + 1);
        return null;
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : this.map.entrySet()){
            int complement = value - entry.getKey();
            if(complement == entry.getKey()){
                if(entry.getValue() > 1){
                    return true;
                }
            } else {
                if(this.map.containsKey(complement)){
                    return true;
                }
            }
        }
        return false;
    }
}