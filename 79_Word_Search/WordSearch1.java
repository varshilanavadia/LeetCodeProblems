public class WordSearch1 {
    int m, n, w;
    char[][] board;
    boolean[][] visited;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    String word;

    public boolean exists(char[][] board, String word){
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.word = word;
        this.w = word.length();
        this.visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j] && dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if(!isValid(i, j)){
            return false;
        }

        if(index+1 >= this.w){
            return true;
        }

        this.visited[i][j] = true;

        for(int[] dir : dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(isValid(new_i, new_j) && this.board[new_i][new_j] == this.word.charAt(index+1)
                    && dfs(new_i, new_j, index+1)){
                return true;
            }
        }

        this.visited[i][j] = false;
        return false;

    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < this.m && j >= 0 && j < this.n && !this.visited[i][j];
    }

    private boolean isNotValid(int i, int j) {
        return i < 0 || i >= this.m || j < 0 || j >= this.n || this.visited[i][j];
    }
}