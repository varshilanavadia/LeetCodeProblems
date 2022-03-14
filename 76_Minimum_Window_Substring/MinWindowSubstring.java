import sun.misc.InnocuousThread;

import java.util.HashMap;

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

    public String minimumWindowSubstring(String str, String pattern){
        if(str.length() == 0 || pattern.length() == 0){
            return "";
        }

        int i = 0, minLen = Integer.MAX_VALUE, substrStart = 0, matched = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character p :
                pattern.toCharArray()) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (int j = 0; j < str.length(); j++) {
            Character c = str.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0){
                    matched++;
                }
            }

            while(matched == pattern.length()){
                if(minLen > j - i + 1){
                    minLen = j-i+1;
                    substrStart = i;
                }

                Character d = str.charAt(i++);
                if(map.containsKey(d)){
                    if(map.get(d) == 0){
                        matched--;
                    }
                    map.put(d, map.get(d) + 1);
                }
            }
        }

        return minLen > str.length() ? "" : str.substring(substrStart, substrStart + minLen);
    }

    public static void main(String[] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();

        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowSubstring.minWindow("aa", "a"));
        System.out.println(minWindowSubstring.minWindow("VaRkjdsfghssRasfhgRsHiL", "sss"));
        System.out.println(minWindowSubstring.minWindow("kjsdfhaklsfuhbahbckarufbaksdjfkasjdgkjasgdhkjasghirwncaksdjbfd", "kjds"));

        System.out.println(minWindowSubstring.minimumWindowSubstring("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowSubstring.minimumWindowSubstring("aa", "a"));
        System.out.println(minWindowSubstring.minimumWindowSubstring("VaRkjdsfghssRasfhgRsHiL", "sss"));
        System.out.println(minWindowSubstring.minimumWindowSubstring("kjsdfhaklsfuhbahbckarufbaksdjfkasjdgkjasgdhkjasghirwncaksdjbfd", "kjds"));
    }
}
