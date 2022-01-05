public class Sol1143 {
    public static void main(String[] args) {
        LCS lcs = new LCS();

        System.out.println(lcs.longestCommonSubsequence_bottomUp("abcde", "ace"));
        System.out.println(lcs.longestCommonSubsequence_topDown("abcde","ace"));
    }
}
