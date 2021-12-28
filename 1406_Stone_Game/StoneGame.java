import java.util.Arrays;

public class StoneGame  {
    int n;
    int[] stoneValue;

    public String playGame3_TopDown(int[] stoneValue) {
        this.n = stoneValue.length;
        this.stoneValue = stoneValue;

        int[] dp = new int[this.n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[this.n] = 0;

        for (int i = n-1; i >= 0 ; i--) {
            int score = 0;
            for(int j = 0; j < 3; j++){
                if(i + j  < this.n) {
                    score += this.stoneValue[i + j];
                    dp[i] = Math.max(dp[i], score - dp[i + j + 1]);
                }
            }
        }

        if(dp[0] > 0) return "Alice";
        if(dp[0] < 0) return "Bob";
        return "Tie";
    }

    Integer[] dp;
    public String playGame3_BottomUp(int[] stoneValue) {
        this.dp = new Integer[this.n + 1];

        // Alice's score = Stones collected by Alice - Stones collected by Bob
        int aliceScore = getScore(0);

        if(aliceScore > 0) return "Alice";
        if(aliceScore < 0) return "Bob";
        return "Tie";
    }

    private int getScore(int index) {
        if(index >= this.n){
            return 0;
        }

        if(this.dp[index] != null){
            return this.dp[index];
        }

        int maxScore = Integer.MIN_VALUE, take = 0;

        for(int i = 0; i < 3; i++){
            if(index + i < this.n){
                take += this.stoneValue[index];
                int score = take - getScore(index + 1);
                maxScore = Math.max(maxScore, score);
            }
        }

        return this.dp[index] = maxScore;
    }
}