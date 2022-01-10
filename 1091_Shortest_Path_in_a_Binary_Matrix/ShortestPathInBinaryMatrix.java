import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    int[][] directions = new int[][]{{-1, 1}, {0, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }

        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        int distance = 1;

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                int row = current[0], col = current[1];
                if(row == m-1 && col == n-1){
                    return distance;
                }

                List<int[]> neighbours = getNeighbours(row, col, grid);
                for(int[] neighbour : neighbours){
                    if(!visited[neighbour[0]][neighbour[1]]){
                        queue.add(neighbour);
                        visited[neighbour[0]][neighbour[1]] = true;
                    }
                }
            }
            distance++;
        }

        return -1;
    }

    private boolean isValid(int row, int col, int[][] grid){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid){
        List<int[]> list = new ArrayList();

        for(int[] dir: directions){
            int newX = row + dir[0];
            int newY = col + dir[1];
            if(isValid(newX, newY, grid)){
                list.add(new int[]{newX, newY});
            }
        }
        return list;
    }
}
