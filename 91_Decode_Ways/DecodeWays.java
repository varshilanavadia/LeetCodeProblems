public class DecodeWays {
    public int numDecodings(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first >= 1 && first <= 9){
                memo[i] += memo[i-1];
            }
            if(second >= 10 && second <= 26){
                memo[i] += memo[i-2];
            }
        }
        return memo[n];
    }
}
