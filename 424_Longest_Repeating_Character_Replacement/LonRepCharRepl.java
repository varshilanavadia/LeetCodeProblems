import java.util.HashMap;
import java.util.Map;

public class LonRepCharRepl {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxCharFreq = 0, maxLen = Integer.MIN_VALUE;
        while(j < s.length()){
            Character c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxCharFreq = Math.max(maxCharFreq, map.get(c));
            if(j-i+1-maxCharFreq > k){
                Character d = s.charAt(i);
                map.put(d, map.get(d) - 1);
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LonRepCharRepl obj = new LonRepCharRepl();

    }
}
