import java.util.HashMap;

public class MaxConsecOnes {
    public int findLength(int[] arr, int k) {
        int i = 0, j = 0;
        int maxLen = Integer.MIN_VALUE, maxOneCount = 0;

        while(j < arr.length){
            if(arr[j] == 1){
                maxOneCount++;
            }
            if(j-i+1 - maxOneCount > k){
                if(arr[i] == 1){
                    maxOneCount--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxConsecOnes ReplacingOnes = new MaxConsecOnes();
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }

}
