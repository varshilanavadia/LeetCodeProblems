import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> q = new LinkedList();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0){
            return 0;
        }

        if(q.size() == 0){
            return -1;
        }

        int minutes = -1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] current = q.remove();
                int row = current[0];
                int col = current[1];

                for(int[] dir: dirs){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(isValid(newRow, newCol, m, n, grid)){
                        q.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }

        return freshOranges > 0 ? -1 : minutes;

    }

    private boolean isValid(int x, int y, int m, int n, int[][] grid){
        return x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1;
    }
}
