import java.util.*;

public class Permutations {

    // 46 - Permutations 1
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        List<Integer> numbers = new ArrayList();

        for(int num: nums){
            numbers.add(num);
        }

        backtrack1(numbers, result, 0);

        return result;
    }

    private void backtrack1(List<Integer> numbers, List<List<Integer>> result, int index){
        if(index == numbers.size()){
            result.add(new ArrayList(numbers));
            return;
        }

        for(int i = index; i < numbers.size(); i++){
            Collections.swap(numbers, i, index);
            backtrack1(numbers, result, index + 1);
            Collections.swap(numbers, i, index);
        }

    }

    // 47 - Permutations 2
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet();

        List<Integer> numbers = new ArrayList();

        for(int num: nums){
            numbers.add(num);
        }

        backtrack2(numbers, result, 0);

        return new ArrayList(result);
    }

    private void backtrack2(List<Integer> numbers, Set<List<Integer>> result, int index){
        if(index == numbers.size()){
            result.add(new ArrayList(numbers));
            return;
        }

        for(int i = index; i < numbers.size(); i++){
            Collections.swap(numbers, i, index);
            backtrack2(numbers, result, index + 1);
            Collections.swap(numbers, i, index);
        }

    }
}
