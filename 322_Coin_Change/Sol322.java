public class Sol322 {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();

        System.out.println(coinChange.coinChange1_topDown(new int[]{1,2,5}, 11));
        System.out.println(coinChange.coinChange1_topDown(new int[]{2}, 3));
        System.out.println(coinChange.coinChange1_topDown(new int[]{1}, 0));
        System.out.println(coinChange.coinChange1_topDown(new int[]{1,2,5,10}, 17));

        System.out.println(coinChange.coinChange1_bottomUp(new int[]{1,2,5}, 11));
        System.out.println(coinChange.coinChange1_bottomUp(new int[]{2}, 3));
        System.out.println(coinChange.coinChange1_bottomUp(new int[]{1}, 0));
        System.out.println(coinChange.coinChange1_bottomUp(new int[]{1,2,5,10}, 17));
    }
}
