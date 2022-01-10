import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeadsToDestination {

    // Using Toplogical Sorting and DP
    int index; // Index for topological sorting
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
        }

        int[] sortedNodes = new int[n];

        this.index = n-1;

        boolean isCycle = topologicalSort(graph, sortedNodes, new boolean[n], source, new HashSet<Integer>());

        System.out.println(Arrays.toString(sortedNodes));

        if(isCycle) return false;

        if(sortedNodes[n-1] != destination) return false;

        boolean[] dp = new boolean[n];
        dp[destination] = true;

        for(int i = n-2; i >= 0; i--){
            if (sortedNodes[i] == 0) break;
            int curr = sortedNodes[i];
            if(graph[curr].isEmpty()){
                return false;
            }
            for(Integer next: graph[curr]){
                if(!dp[next]){
                    return false;
                }
            }
            dp[curr] = true;
        }

        return true;
    }

    private boolean topologicalSort(List<Integer>[] graph, int[] sortedNodes, boolean[] visited, int node, HashSet<Integer> currentlyVisiting){
        visited[node] = true;
        currentlyVisiting.add(node);

        for(Integer next: graph[node]){
            if (currentlyVisiting.contains(next)) {
                return true;
            }
            if(!visited[next]){
                if(topologicalSort(graph, sortedNodes, visited, next, currentlyVisiting)){
                    return true;
                }
            }
        }

        currentlyVisiting.remove(node);
        sortedNodes[index--] = node;
        return false;
    }
}
