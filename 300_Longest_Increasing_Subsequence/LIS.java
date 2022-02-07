import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LIS {
    public int lengthOfLIS_dymanic_programming(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    memo[i] = Math.max(memo[i], memo[j]+1);
                }
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for(int len: memo){
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    // Intelligently build sequence
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > numList.get(numList.size() - 1)){
                numList.add(nums[i]);
            } else {
//                int indexToAdd = Collections.binarySearch(numList, nums[i]);
//                if(indexToAdd < 0){
//                    numList.set(-indexToAdd-1, nums[i]);
//                }
                int indexToAdd = binarySearch(numList, nums[i]);
                numList.set(indexToAdd, nums[i]);
            }
        }

        return numList.size();
    }

    private int binarySearch(ArrayList<Integer> numList, int num) {
        int left = 0, right = numList.size()-1, result = -1;

        while(left <= right){
           int mid = left + (right - left)/2;
            if(numList.get(mid) >= num){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

}
