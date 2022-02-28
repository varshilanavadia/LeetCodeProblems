public class MinWindowSubSeq {
    public String minimumSWindowSubsequence(String s, String t){
        int m = s.length(), n = t.length();

        if(m == 0 || n == 0){
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        int right = 0;
        String result = "";

        while(right < m){

            int p = 0;
            while(right < m){
                if(s.charAt(right) == t.charAt(p)){
                    p++;
                }
                if(p == n){
                    break;
                }
                right++;
            }

            int left = right;
            p = n-1;
            while(left >= 0){
                if(s.charAt(left) == t.charAt(p)){
                    p--;
                }
                if(p < 0){
                    break;
                }
                left--;
            }

            if(right - left + 1 < minLen){
                minLen = right - left + 1;
                result = s.substring(left, right+1);
            }

            right = left + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        MinWindowSubstring obj = new MinWindowSubstring();
        System.out.println(obj.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u"));
        System.out.println(obj.minWindow("abcdebdde", "bde"));
        System.out.println(obj.minWindow("hgksjghiauviahgjkafghqpqrtuiabvahlgweiybakuhvawrilcfbargafhgadsgfjhasvnmzxmabweyfgsdp", "ljsh"));


    }
}
