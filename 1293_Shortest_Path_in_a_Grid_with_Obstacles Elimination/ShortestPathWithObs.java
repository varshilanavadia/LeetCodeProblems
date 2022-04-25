import java.util.*;

public class ShortestPathWithObs {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k+1];
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int len = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1], currk = curr[2];
                if(x == m-1 && y == n-1) return len;

                for(int[] d: dirs){
                    int nextX = x + d[0];
                    int nextY = y + d[1];
                    if(isValid(nextX, nextY, m, n)){
                        if(grid[nextX][nextY] == 0 && !visited[nextX][nextY][currk]){
                            queue.offer(new int[]{nextX, nextY, currk});
                            visited[nextX][nextY][currk] = true;
                        } else {
                            if(currk > 0 && !visited[nextX][nextY][currk-1]){
                                queue.offer(new int[]{nextX, nextY, currk-1});
                                visited[nextX][nextY][currk-1] = true;
                            }
                        }
                    }
                }
            }
            len++;
        }

        return -1;
    }

    private boolean isValid(int x, int y, int m, int n){
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
