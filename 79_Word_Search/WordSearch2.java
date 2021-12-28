import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    Set<String> result;
    int m, n;
    char[][] board;
    boolean[][] visited;
    int[][] dirs;


    public List<String> findWords(char[][] board, String[] words) {
        Trie_212 trie = new Trie_212();

        for(String word : words){
            trie.addWord(word);
        }

        this.result = new HashSet();
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.visited = new boolean[m][n];
        this.dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(Character c : trie.root.neighbours.keySet()){
            for(int i = 0; i < this.m; i++){
                for(int j = 0; j < this.n; j++){
                    if(this.board[i][j] == c){
                        dfs(i, j, trie.root.neighbours.get(c), new StringBuilder());
                    }
                }
            }
        }

        return new ArrayList(result);
    }

    public boolean isValid(int i, int j){
        return i >= 0 && j >= 0 && i < this.m && j < this.n && !this.visited[i][j];
    }

    public void dfs(int i, int j, TrieNode_212 node, StringBuilder sb){
        this.visited[i][j] = true;
        sb.append(this.board[i][j]);

        if(node.isWord){
            this.result.add(sb.toString());
        }

        for(int[] dir : dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            for(Character d : node.neighbours.keySet()){
                if(isValid(new_i, new_j) && d == this.board[new_i][new_j]){
                    dfs(new_i, new_j, node.neighbours.get(d), sb);
                }
            }
        }


        this.visited[i][j] = false;
        sb.setLength(sb.length() - 1);
    }
}





//
//class Solution {
//    Set<String> res;
//    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    int m, n;
//    char[][] board;
//    boolean[][] visited;
//
//    public List<String> findWords(char[][] board, String[] words) {
//        m = board.length;
//        n = board[0].length;
//        this.board = board;
//        res = new HashSet();
//
//        Trie trie = new Trie();
//        for (String word: words) {
//            trie.addWord(word);
//        }
//
//        visited = new boolean[m][n];
//        StringBuilder sb = new StringBuilder();
//
//        for (char c: trie.root.neighbors.keySet()) {
//            for (int i = 0; i < m; i++) {
//                for(int j = 0; j < n; j++) {
//                    if (board[i][j] == c) {
//                        dfs(i, j, trie.root.neighbors.get(c), sb);
//                    }
//                }
//            }
//        }
//        return new ArrayList(res);
//    }
//
//    private boolean isNotValid(int i, int j){
//        return i < 0 || j < 0 || i >= m || j >= n || visited[i][j];
//    }
//
//
//    private void dfs(int i, int j, TrieNode node, StringBuilder sb) {
//        visited[i][j] = true;
//        sb.append(board[i][j]);
//
//        if (node.isWord) {
//            res.add(sb.toString());
//        }
//
//        for (int[] dir: dirs) {
//            int newX = i + dir[0];
//            int newY = j + dir[1];
//            for(char nextChar: node.neighbors.keySet()) {
//                if (!isNotValid(newX, newY) && nextChar == board[newX][newY]) {
//                    dfs(newX, newY, node.neighbors.get(nextChar), sb);
//                }
//            }
//        }
//
//        visited[i][j] = false;
//        sb.setLength(sb.length() - 1);
//    }
//}
//

