import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContainsDup {

    // 219 - Contains Duplicate 2
    public boolean containsNearDup(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    // 220 - Contains Duplicate 3
    public boolean containsNearDup(int[] nums, int k, int t){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer c = set.ceiling(nums[i]);
            if(c != null && c <= t + nums[i]){
                return true;
            }

            Integer f = set.floor(nums[i]);
            if(f != null && nums[i] <= f + t){
                return true;
            }

            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
