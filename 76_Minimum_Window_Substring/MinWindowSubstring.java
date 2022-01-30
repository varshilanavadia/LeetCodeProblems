public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();

        if(m == 0 || n == 0){
            return "";
        }

        int[] targetMap = new int[128], substringMap = new int[128];
        int left = 0, right = 0, start = 0, end = 0, minLen = Integer.MAX_VALUE;
        int target = 0, formedCurrently = 0;

        for(char c: t.toCharArray()){
            targetMap[c]++;
        }
        for(int num: targetMap){
            if(num > 0){
                target++;
            }
        }

        while(right < n){
            char c = s.charAt(right);
            substringMap[c]++;

            if(targetMap[c] > 0 && substringMap[c] == targetMap[c]){
                formedCurrently++;
            }

            while(left <= right && formedCurrently == target){
                char d = s.charAt(left);
                int currentLen = right - left + 1;

                if(minLen == Integer.MAX_VALUE || currentLen < minLen){
                    minLen = currentLen;
                    start = left;
                    end = right;
                }

                substringMap[d]--;
                if(targetMap[d] > 0 && substringMap[d] < targetMap[d]){
                    formedCurrently--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end+1);
    }
}
