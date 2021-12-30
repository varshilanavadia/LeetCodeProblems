import java.util.PriorityQueue;

public class TrappingRainWater {

    // 42 - Trapping Rain Water 1
    public int trap_using_dp(int[] height) {
        int n = height.length;
        int[] leftMaxHeights = new int[n];
        int[] rightMaxHeights = new int[n];
        leftMaxHeights[0] = height[0];
        rightMaxHeights[n-1] = height[n-1];

        for (int i = 1; i < n; i++) {
            leftMaxHeights[i] = Math.max(height[i], leftMaxHeights[i-1]);
        }

        for (int i = n-2; i >= 0; i--) {
            rightMaxHeights[i] = Math.max(height[i], rightMaxHeights[i+1]);
        }

        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(rightMaxHeights[i], leftMaxHeights[i]) - height[i];
        }

        return waterTrapped;
    }

    public int trap_using_2ptr(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0, i = 0, j = n-1, waterTrapped = 0;

        while(i < j){
            if(height[i] < height[j]) {
                if (height[i] >= leftMax) {
                    leftMax = Math.max(leftMax, height[i]);
                } else {
                    waterTrapped += leftMax - height[i];
                }
                i++;
            } else {
                if (height[j] >= rightMax) {
                    rightMax = Math.max(rightMax, height[j]);
                } else {
                    waterTrapped += rightMax - height[j];
                }
                j--;
            }
        }

        return waterTrapped;
    }

    // 407 - Trapping Rain Water 2
    /*
     * Idea: Use Priority Queue + BFS --> Djikstra's Algorithm
     * Priority Queue because you want to visit elements of heightMap in increasing order of their heights.
     * Initially, add all the border cells/points to the priority queue.
     * From the borders, pick the shortest cell/point and check its neighbours. If the neighbour is shorter,
     * collect the water it can trap and update its height as its height plus the water trapped.
     * Add all neighbours to continue BFS.
     * It is important to update the height of the neighbouring cells as you fill their water.
     * */

    int m, n;
    int[][] heightMap;
    boolean[][] visited;

    public int trapRainWater2(int[][] heightMap){
        this.m = heightMap.length;
        this.n = heightMap[0].length;
        this.heightMap = heightMap;
        this.visited = new boolean[m][n];

        PriorityQueue<HeightMapCell> queue = new PriorityQueue<HeightMapCell>((a, b) -> a.height - b.height);

        for(int i = 0; i < this.m; i++){
            for(int j = 0; j < this.n; j++){
                if(i == 0 || j == 0 || i == this.m-1 || j == this.n-1){
                    queue.offer(new HeightMapCell(i, j, heightMap[i][j]));
                    this.visited[i][j] = true;
                }
            }
        }

        int waterTrapped = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!queue.isEmpty()){
            HeightMapCell curr = queue.poll();
            for(int[] dir : dirs){
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];
                if(isValid(newX, newY)){
                    this.visited[newX][newY] = true;
                    waterTrapped += Math.max(0, curr.height - heightMap[newX][newY]);
                    queue.offer(new HeightMapCell(newX, newY, Math.max(curr.height, heightMap[newX][newY])));
                }
            }
        }

        return waterTrapped;
    }

    private boolean isValid(int x, int y){
        return x >= 0 && x < this.m && y >= 0 && y < this.n && !this.visited[x][y];
    }
}
