public class Sol1406 {
    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        int[][] stoneValues = {{1, 2, 3, 7}, {1, 2, 3, -9}, {1, 2, 3, 6}};

        for(int[] array : stoneValues){
            System.out.println(stoneGame.playGame3_TopDown(array));
            System.out.println(stoneGame.playGame3_BottomUp(array));
        }
    }
}