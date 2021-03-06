public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int costDelete = 1 + dp[i-1][j];
                int costInsert = 1 + dp[i][j-1];
                int costReplace = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    costReplace++;
                }
                dp[i][j] = Math.min(costReplace, Math.min(costInsert, costDelete));
            }
        }

        return dp[m][n];
    }

    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length(), lenT = t.length();

        if(lenS > lenT){
            return isOneEditDistance(t, s);
        }

        if(lenT - lenS > 1){
            return false;
        }

        for(int i = 0; i < lenS; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(lenS == lenT){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }

        return lenS + 1 == lenT;
    }
}
