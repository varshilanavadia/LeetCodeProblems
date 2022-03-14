import java.util.HashMap;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int i = 0, matched = 0;

        for(Character c: pattern.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (int j = 0; j < str.length(); j++) {
            Character c = str.charAt(j);

            if(freqMap.containsKey(c)){
                freqMap.put(c, freqMap.get(c) - 1);
                if(freqMap.get(c) == 0){
                    matched++;
                }
            }

            if(matched == freqMap.size()){
                return true;
            }

            if(j >= pattern.length()-1){
                Character d = str.charAt(i++);
                if(freqMap.containsKey(d)){
                    if(freqMap.get(d) == 0){
                        matched--;
                    }
                    freqMap.put(d, freqMap.get(d) + 1);
                }
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }
}

