import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        int i = 0, matched = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character p: pattern.toCharArray()) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (int j = 0; j < str.length(); j++) {
            Character c = str.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    matched++;
                }
            }

            if(matched == map.size()){
                resultIndices.add(i);
            }

            if(j >= pattern.length()-1){
                Character d = str.charAt(i++);
                if(map.containsKey(d)){
                    if(map.get(d) == 0){
                        matched--;
                    }
                    map.put(d, map.get(d) + 1);
                }
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
