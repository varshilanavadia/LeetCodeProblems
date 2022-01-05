public class LCS {

    // O(MN) Time, O(MN) Space
    public int longestCommonSubsequence_bottomUp(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }

    // O(MN) Time, O(MN) Space + Recursion Overhead
    public int longestCommonSubsequence_topDown(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] memo = new int[len1+1][len2+1];

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                memo[i][j] = -1;
            }
        }

        return topDownDP(text1, text2, memo, len1, len2);
    }

    private int topDownDP(String text1, String text2, int[][] memo, int i, int j){
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            memo[i][j] = topDownDP(text1, text2, memo, i-1, j-1) + 1;
        } else {
            memo[i][j] = Math.max(topDownDP(text1, text2, memo, i, j-1), topDownDP(text1, text2, memo, i-1, j));
        }

        return memo[i][j];
    }

}
