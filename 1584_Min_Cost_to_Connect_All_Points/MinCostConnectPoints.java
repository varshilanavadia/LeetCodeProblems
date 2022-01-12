import java.util.PriorityQueue;

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int[] p1 = points[i];
                int[] p2 = points[j];
                int weight = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                pq.offer(new int[]{i, j, weight});
            }
        }

        int numEdges = 0;
        int minCost = 0;
        while(numEdges < n-1){
            int[] edge = pq.poll();
            if(uf.union(edge[0], edge[1])){
                numEdges++;
                minCost += edge[2];
            }
        }

        return minCost;
    }
}
