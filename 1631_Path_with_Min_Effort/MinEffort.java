import java.util.Arrays;
import java.util.PriorityQueue;

class Coordinate{
    int x, y, effort;
    public Coordinate(int x, int y, int effort){
        this.x = x;
        this.y = y;
        this.effort = effort;
    }

}
public class MinEffort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Coordinate> heap = new PriorityQueue<>(
                (a, b) -> a.effort - b.effort
        );
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};

        int m = heights.length-1, n = heights[0].length-1;
        int[][] maxEfforts = new int[m+1][n+1];
        for(int[] e: maxEfforts){
            Arrays.fill(e, Integer.MAX_VALUE);
        }

        heap.offer(new Coordinate(0, 0, 0));
        maxEfforts[0][0] = 0;


        while(!heap.isEmpty()){
            Coordinate curr = heap.poll();
            int e = curr.effort, x = curr.x, y = curr.y;
            if(x == m && y == n){
                return e;
            }

            for(int[] d: dirs){
                int newX = x + d[0];
                int newY = y + d[1];
                if(isValid(newX, newY, m, n)){
                    int nextEffort = Math.max(Math.abs(heights[newX][newY] - heights[x][y]), e);
                    if(maxEfforts[newX][newY] > nextEffort){
                        maxEfforts[newX][newY] = nextEffort;
                        heap.offer(new Coordinate(newX, newY, nextEffort));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, int m, int n){
        return x >= 0 && x <= m & y >= 0 && y <= n;
    }

    public static void main(String[] args) {
        MinEffort obj = new MinEffort();
        System.out.println(obj.minimumEffortPath(new int[][]{{1,2,2}, {3,8,2}, {5,3,5}}));
        System.out.println(obj.minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
        System.out.println(obj.minimumEffortPath(new int[][]{{1,2,2}, {3,8,2}, {5,3,5}}));
    }
}