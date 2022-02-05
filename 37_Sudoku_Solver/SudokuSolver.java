public class SudokuSolver {
    private final int gridSize = 9;

    public int[][] solve(int[][] board){
        solveHelper(board, 0, 0);
        return board;
    }

    private boolean solveHelper(int[][] board, int row, int col) {
        if(col == gridSize){
            col = 0;
            row += 1;
        }

        if(row == 9){
            return true;
        }

        if(board[row][col] != 0){
            return solveHelper(board, row, col+1);
        }

        for(int num = 1; num <= 9; num++){
            if(board[row][col] == 0 && isValidPlacement(board, row, col, num)){
                board[row][col] = num;
                if(solveHelper(board, row, col+1)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValidPlacement(int[][] board, int row, int col, int num) {
        return !isInRow(board, col, num) && !isInColumn(board, row, num) && !isInBox(board, row, col, num);
    }

    private boolean isInBox(int[][] board, int row, int col, int num) {
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if(board[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInColumn(int[][] board, int row, int num) {
        for(int i = 0; i < gridSize; i++){
            if(board[row][i] == num){
                return true;
            }
        }
        return false;
    }

    private boolean isInRow(int[][] board, int col, int num) {
        for(int i = 0; i < gridSize; i++){
            if(board[i][col] == num){
                return true;
            }
        }
        return false;
    }


}
