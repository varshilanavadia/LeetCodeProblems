import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervals.merge((array));
        System.out.println(Arrays.deepToString(result));
    }
}
