import java.util.HashMap;
import java.util.Map;

public class KnightDialer {
    // VERSION 1 - SIMPLE RECURSION/DFS, RESULTS IN TIME LIMIT EXCEEDED FOR LARGE NUMBERS OF N
    /*
    * int count = 0;
    * public int knightDialer(int n) {
    * if(n == 1) return 10;

    * int[][] dirs = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};


    * for(int i = 0; i < 4; i++){
    * for(int j = 0; j < 3; j++){
    * backtrack((i*3+j) + 1, 1, n, dirs);
    * }
    * }
    * return count % 1000000007;
    * }

    * private void backtrack(int current, int len, int n, int[][] dirs){
    * if(current == 10 || current == 12){
    * return;
    * }

    * if(len == n){
    * count++;
    * return;
    * }

    * int i = (current-1) / 3;
    * int j = (current-1) % 3;

    * for(int[] dir: dirs){
    * int next_i = i + dir[0];
    * int next_j = j + dir[1];
    * if(isValid(next_i, next_j)){
    * backtrack((next_i*3 + next_j)+1, len+1, n, dirs);
    * }
    * }
    * }

    * private boolean isValid(int i, int j){
    * return i >= 0 && j >= 0 && i < 4 && j < 3;
    * }
    * */



    long count = 0;
    public int knightDialer(int n) {
        int[][] dirs = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        Map<String, Long> map = new HashMap();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                int current = (i*3+j) + 1;
                count += (backtrack(current, n, dirs, map)) % 1000000007;
                count %= 1000000007;
            }
        }
        return (int) count;
    }

    private long backtrack(int current, int n, int[][] dirs, Map<String, Long> map){
        if(current == 10 || current == 12){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        String key = current + ":" + n;

        if(map.containsKey(key)){
            return map.get(key);
        }

        long m = 0;
        int i = (current-1) / 3;
        int j = (current-1) % 3;
        for(int[] dir: dirs){
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            if(isValid(next_i, next_j)){
                m += backtrack((next_i*3 + next_j)+1, n-1, dirs, map) % 1000000007;
                m = m % 1000000007;
            }
        }

        map.put(key, m);
        return m;
    }

    private boolean isValid(int i, int j){
        return i >= 0 && j >= 0 && i < 4 && j < 3;
    }
}