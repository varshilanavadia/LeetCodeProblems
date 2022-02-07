import java.util.Arrays;

public class CoinChange {
    public int coinChange1_topDown(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        int[] dp = new int[amount+1];
        exchange(coins, amount, dp);
        return dp[amount] == dp.length ? -1 : dp[amount];
    }

    private int exchange(int[] coins, int amount, int[] dp) {
        if(amount == 0){
            return 0;
        }

        if(dp[amount] > 0){
            return dp[amount];
        }

        int minCoins = dp.length;
        for(int coin: coins){
            if(amount - coin >= 0){
                minCoins = Math.min(minCoins, exchange(coins, amount - coin, dp) + 1);
            }
        }
        return dp[amount] = minCoins;
    }

    public int coinChange1_bottomUp(int[] coins, int amount){
        if(amount < 1){
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    public int coinChange2_naiveDP(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for(int i = 1; i <= coins.length; i++){
            dp[i][0] = 1;
            for(int j = 1; j <= amount; j++){
                dp[i][j] = dp[i-1][j] + (j - coins[i-1] >= 0 ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    public int coinChange2_optimizedDP(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin: coins){
            for(int x = coin; x < amount+1; x++){
                dp[x] += dp[x-coin];
            }
        }
        return dp[amount];
    }
}
