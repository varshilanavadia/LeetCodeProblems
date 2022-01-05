public class PaintHouse {

    // 256 - Paint House 1
    public int minCost(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++){
            dp[0][i] = costs[0][i];
        }

        for(int i = 1; i < m; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
        }

        int minCost = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            minCost = Math.min(minCost, dp[m-1][j]);
        }

        return minCost;
    }

    // 265 - Paint House 2 in Optimal O(NK) Time
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;

        if(n == 0) return 0;

        for(int h = 1; h < n; h++){

            int minColor = -1, secondMinColor = -1;
            for(int c = 0; c < k; c++){
                if(minColor == -1 || costs[h-1][c] < costs[h-1][minColor]){
                    secondMinColor = minColor;
                    minColor = c;
                } else if(secondMinColor == -1 || costs[h-1][c] < costs[h-1][secondMinColor]){
                    secondMinColor = c;
                }
            }

            for(int c = 0; c < k; c++){
                if(c == minColor){
                    costs[h][c] += costs[h-1][secondMinColor];
                } else {
                    costs[h][c] += costs[h-1][minColor];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int cost : costs[n-1]){
            result = Math.min(cost, result);
        }

        return result;
    }
}
