import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;

    // 39 - Combination Sum 1
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        result = new ArrayList();

        findCandidates1(candidates, target, 0, new LinkedList());

        return this.result;
    }

    private void findCandidates1(int[] candidates, int target, int index, LinkedList<Integer> list){
        if(target == 0){
            this.result.add(new ArrayList(list));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(target - candidates[i] >= 0){
                list.addLast(candidates[i]);
                findCandidates1(candidates, target - candidates[i], i, list);
                list.removeLast();
            }
        }
    }

    // 40 - Combination Sum 2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList();

        Arrays.sort(candidates);

        findCandidates2(candidates, target, 0, new LinkedList());

        return this.result;
    }

    private void findCandidates2(int[] candidates, int target, int index, LinkedList<Integer> list){
        if(target == 0){
            this.result.add(new ArrayList(list));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1])
                continue;

            if(target - candidates[i] < 0){
                break;
            }

            list.addLast(candidates[i]);
            findCandidates2(candidates, target - candidates[i], i+1, list);
            list.removeLast();
        }
    }

    // 216 - Combination Sum 3
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.result = new ArrayList();

        findCandidates3(k, n, 1, new LinkedList<Integer>());

        return this.result;
    }

    private void findCandidates3(int k, int n, int num, LinkedList<Integer> list){
        if(k == 0){
            if(n == 0){
                this.result.add(new ArrayList(list));
            }
            return;
        }

        for(int x = num; x <= 9; x++){
            if(n - x < 0)
                break;

            list.add(x);
            findCandidates3(k-1, n-x, x+1, list);
            list.removeLast();
        }

    }

    // 377 Combination Sum 4
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];

        memo[0] = 1;

        Arrays.sort(nums);

        return findCombinations(nums, target, memo);
    }

    private int findCombinations(int[] nums, int target, Integer[] memo){
        if(target == 0){
            return 1;
        }

        if(memo[target] != null){
            return memo[target];
        }

        int subComb = 0;
        for(int i = 0; i < nums.length; i++){
            if(target - nums[i] < 0)
                break;

            subComb += findCombinations(nums, target - nums[i], memo);
        }

        return memo[target] = subComb;
    }
}
