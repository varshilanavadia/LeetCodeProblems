import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(String str : strs){
            String key = getKey(str);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String s){
        /*
        * - This approach to create key takes O(m*log(m)) time, where 'm' is the length of a string.
        * - For the whole algorithm sort will be applied to all strings which results in a total of
        * O(N*M*log(M)) time, where 'M" is the length of the largest string in strs and 'N' is the
        * number of strings in strs.
        * - To optimize, consider created a hashtable of size 26 (coz all alphabets) for each string
        * as the key where the hashtable contains count of each character in the string + delimited char
        * and return the string value of this hashtable as the key, for eg, 0#0#1#0#2#0#1#0#0#0...
        * - This reduces the overall complexity to O(NM).
        * */
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}
