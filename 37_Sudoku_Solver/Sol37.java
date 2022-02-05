import java.util.Arrays;
import java.util.Random;

public class Sol37 {
    public static void main(String[] args) {
        leetCodeProblem();
        myOwnCodeToSolveSudoku();
    }

    private static void myOwnCodeToSolveSudoku() {
        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] board = new int[][]{{5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},{4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}};
        printBoard(board);
        int[][] result = sudokuSolver.solve(board);
        printBoard(result);

    }

    private static void printBoard(int[][] board) {
        for(int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    private static void leetCodeProblem() {
        SolveSudoku solveSudoku = new SolveSudoku();
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        char[][] result = new char[][]{{'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},{'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},{'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},{'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},{'3','4','5','2','8','6','1','7','9'}};

        solveSudoku.solveSudoku(board);

        System.out.println(compare(board, result) + "\n");
    }

    private static boolean compare(char[][] board, char[][] result) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != result[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

