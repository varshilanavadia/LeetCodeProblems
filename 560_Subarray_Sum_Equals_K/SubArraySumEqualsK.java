import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}


