import java.util.Arrays;

public class Sol364 {
    public static void main(String[] args) throws Exception {
        NestedListWeightSum nestedListWeightSum = new NestedListWeightSum();

        NestedList a = new NestedList(Arrays.asList(new NestedInt(6)));
        NestedList b = new NestedList(Arrays.asList(new NestedInt(4), a));
        NestedList c = new NestedList(Arrays.asList(new NestedInt(1), b));

        System.out.println(nestedListWeightSum.depthSum_bfs(Arrays.asList(new NestedInt(1), b)));
        System.out.println(nestedListWeightSum.depthSum_dfs(Arrays.asList(new NestedInt(1), b)));
        System.out.println(nestedListWeightSum.depthSumInverse(Arrays.asList(new NestedInt(1), b)));

    }
}
