public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if(col == 9){
            row += 1;
            col = 0;
        }

        if(row == 9){
            return true;
        }

        if(board[row][col] != '.'){
            return solve(board, row, col+1);
        }

        for(char c = '1'; c <= '9'; c++){
            if(board[row][col] == '.'){
                if(isvalid(board, row, col, c)){
                    board[row][col] = c;
                    if(solve(board, row, col+1)){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    private boolean isvalid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c || board[i][col] == c || board[3*(row/3) + i/3][3*(col/3) + i%3] == c){
                return false;
            }
        }
        return true;
    }
}
