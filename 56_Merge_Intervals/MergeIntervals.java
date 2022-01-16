import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> mergedIntervals = new Stack();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        mergedIntervals.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] top = mergedIntervals.peek();
            if(intervals[i][0] <= top[1]){
                top[1] = Math.max(intervals[i][1], top[1]);
            } else {
                mergedIntervals.push(intervals[i]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public int[][] merge_using_stack(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> s = new Stack();
        s.push(intervals[0]);

        for(int i = 1; i < n; i++){
            int[] curr = intervals[i];
            if(curr[0] <= s.peek()[1]){
                if(s.peek()[1] < curr[1])
                    s.peek()[1] = curr[1];
            } else {
                s.push(curr);
            }
        }

        return s.toArray(new int[s.size()][]);

    }
}