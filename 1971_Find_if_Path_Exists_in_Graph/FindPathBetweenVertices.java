import java.util.*;

public class FindPathBetweenVertices {

    // Using Breadth First Search (BFS)
    public boolean validPath_BFS(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> graph = new HashMap();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == end){
                return true;
            }
            for(Integer neighbour : graph.get(current)){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return false;
    }

    // Using Depth First Search (DFS)
    public boolean validPath_DFS(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> graph = new HashMap();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, start, end, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int end, boolean[] visited){
        if(current == end){
            return true;
        }

        visited[current] = true;
        boolean found = false;
        for(Integer neighbour : graph.get(current)){
            if(!visited[neighbour]){
                found |= dfs(graph, neighbour, end, visited);
            }
        }

        return found;
    }
}
