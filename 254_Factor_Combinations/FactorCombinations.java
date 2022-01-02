import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList();

        if(n <= 3) {
            return result;
        }

        backtrack(n, result, new LinkedList<Integer>(), 2);

        return result;
    }

    private void backtrack(int n, List<List<Integer>> result, LinkedList<Integer> list, int divisor){
        if(n == 1){
            if(list.size() > 1){
                result.add(new ArrayList(list));
            }
            return;
        }

        for(int i = divisor; i <= n; i++){
            if(n % i == 0){
                list.add(i);
                backtrack(n/i, result, list, i);
                list.removeLast();
            }
        }

        /*
        * Optimization below, since factors range from 2 to sqrt(n)
        *
        for(int i = divisor; i*i <= n; i++){
            if(n % i == 0){
                list.add(i);
                backtrack(n/i, result, list, i);
                list.removeLast();
            }
        }

        int i = n;
        list.add(i);
        backtrack(n/i, result, list, i);
        list.removeLast();
        *
        * */
    }
}
