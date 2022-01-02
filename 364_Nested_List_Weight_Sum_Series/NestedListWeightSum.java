import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {

    // 339 - Nested List Weight Sum 1
    public int depthSum_dfs(List<NestedInteger> nestedList) throws Exception {
         return dfs1(nestedList, 1);
    }


    private int dfs1(List<NestedInteger> list, int depth) throws Exception {
        int sum = 0;

        for(NestedInteger n : list){
            if(n.isInteger()){
                sum += n.getInteger() * depth;
            } else {
                sum += dfs1(n.getList(), depth + 1);
            }
        }

        return sum;
    }

    public int depthSum_bfs(List<NestedInteger> nestedList) throws Exception {
        int sum = 0, depth = 1;
        Queue<NestedInteger> queue = new LinkedList();
        queue.addAll(nestedList);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                NestedInteger curr = queue.poll();
                if(curr.isInteger()){
                    sum += curr.getInteger() * depth;
                } else {
                    queue.addAll(curr.getList());
                }
            }
            depth++;
        }

        return sum;

    }


    // 364 - Nested List Weight Sum 2
    public int depthSumInverse(List<NestedInteger> nestedList) throws Exception {
        int maxDepth = findMaxDepth(nestedList);
        return dfs2(nestedList, 1, maxDepth);
    }

    private int dfs2(List<NestedInteger> list, int depth, int maxDepth) throws Exception {
        int sum = 0;

        for(NestedInteger n : list){
            if(n.isInteger()){
                sum += n.getInteger() * (maxDepth - depth + 1);
            } else {
                sum += dfs2(n.getList(), depth + 1, maxDepth);
            }
        }

        return sum;
    }

    private int findMaxDepth(List<NestedInteger> list) throws Exception {
        int maxDepth = 1;
        for(NestedInteger n : list){
            if(!n.isInteger()){
                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(n.getList()));
            }
        }
        return maxDepth;

    }
}
