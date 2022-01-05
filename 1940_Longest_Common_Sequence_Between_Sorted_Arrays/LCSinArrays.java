import java.util.*;

public class LCSinArrays {

    // Optimal Solution O(M log(N)) Time, where N = arrays.length and M = Longest array in arrays
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        return mergeHelper(arrays, 0, arrays.length-1);
    }

    private List<Integer> mergeHelper(int[][] arrays, int left, int right){
        List<Integer> list = new ArrayList();
        if(left > right){
            return list;
        }

        if(left == right){
            for(int num : arrays[left]){
                list.add(num);
            }
            return list;
        }

        int mid = left + (right - left)/2;
        return mergeLists(mergeHelper(arrays, left, mid), mergeHelper(arrays, mid+1, right));
    }

    private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2){
        int i = 0, j = 0;
        List<Integer> result = new ArrayList();
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                i++;
            } else if(list1.get(i) > list2.get(j)){
                j++;
            } else {
                result.add(list1.get(i));
                i++;
                j++;
            }
        }
        return result;
    }

    // Using HASHMAP - O(MN) Time
    public List<Integer> longestCommonSubsequence_usingHashMap(int[][] arrays) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < arrays.length; i++){
            for(int j = 0; j < arrays[i].length; j++){
                map.put(arrays[i][j], map.getOrDefault(arrays[i][j], 0) + 1);

            }
        }

        List<Integer> list = new ArrayList();
        for(int num : arrays[0]){
            if(map.get(num) == arrays.length){
                list.add(num);
            }
        }

        return list;
    }

    // Using HASHSET - O(MN) Time
    public List<Integer> longestCommonSubsequence_usingHashSet(int[][] arrays) {
        Set<Integer> commonElements = new HashSet();
        for(int num : arrays[0]){
            commonElements.add(num);
        }

        for(int i = 1; i < arrays.length; i++){
            Set<Integer> set = new HashSet();
            for(int j = 0; j < arrays[i].length; j++){
                if(commonElements.contains(arrays[i][j])){
                    set.add(arrays[i][j]);
                }
            }
            commonElements = set;
        }

        List<Integer> list = new ArrayList();
        for(int num : arrays[0]){
            if(commonElements.contains(num)){
                list.add(num);
            }
        }

        return list;
    }
}
