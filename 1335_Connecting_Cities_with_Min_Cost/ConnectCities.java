import java.util.Arrays;

public class ConnectCities {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n+1);

        int minCost = 0, total = 0;
        for(int[] connection: connections){
            if(uf.union(connection[0], connection[1])){
                minCost += connection[2];
                total++;
            }
        }

        return total == n-1 ? minCost : -1;
    }
}