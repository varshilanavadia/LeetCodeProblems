public class IsGraphBipartite {
    // APPROACH 1
    public static boolean isBipartite_unionFind(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++){
            int[] e = graph[i];
            for(int j: graph[i]){
                if(uf.find(i) == uf.find(j)){
                    return false;
                }
                uf.union(e[0], j);

            }
        }

        return true;
    }

    // APPROACH 2
    public static boolean isBipartite_dfs(int[][] graph) {
        int n = graph.length;
        Boolean[] colors = new Boolean[n];

        for(int i = 0; i < n; i++){
            if(colors[i] == null){
                colors[i] = true;
                if(!dfs(graph, colors, i))
                    return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, Boolean[] colors, int node){
        boolean result = true;
        for(int nextNode: graph[node]){
            if(colors[nextNode] == colors[node]){
                return false;
            }
            if(colors[nextNode] == null){
                colors[nextNode] = !colors[node];
                result &= dfs(graph, colors, nextNode);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] g1 = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] g2 = new int[][]{{1,3},{0,2},{1,3},{0,2}};

        System.out.println(isBipartite_dfs(g1));
        System.out.println(isBipartite_dfs(g2));

        System.out.println(isBipartite_unionFind(g1));
        System.out.println(isBipartite_unionFind(g2));

    }
}
