public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            memo[i][n-1] = 1;
        }
        for (int i = 0; i < n; i++) {
            memo[m-1][i] = 1;
        }

        for (int i = m-2; i >= 0 ; i--) {
            for (int j = n-2; j >= 0 ; j--) {
                memo[i][j] = memo[i+1][j] + memo[i][j+1];
            }
        }

        return memo[0][0];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];

        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        memo[m-1][n-1] = 1;

        for(int i = m-2; i >= 0; i--){
            if(obstacleGrid[i][n-1] == 1){
                memo[i][n-1] = 0;
            } else {
                memo[i][n-1] = memo[i+1][n-1];
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(obstacleGrid[m-1][i] == 1){
                memo[m-1][i] = 0;
            } else {
                memo[m-1][i] = memo[m-1][i+1];
            }
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                if(obstacleGrid[i][j] == 0){
                    memo[i][j] = memo[i][j+1] + memo[i+1][j];
                } else {
                    memo[i][j] = 0;
                }
            }
        }

        return memo[0][0];
    }
}
