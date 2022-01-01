public class Sol39 {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();

        System.out.println("Combination Sum 1");
        System.out.println(combinationSum.combinationSum1(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum.combinationSum1(new int[]{2, 3, 5}, 8));
        System.out.println(combinationSum.combinationSum1(new int[]{2}, 1));

        System.out.println("\nCombination Sum 2");
        System.out.println(combinationSum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));

        System.out.println("\nCombination Sum 3");
        System.out.println(combinationSum.combinationSum3(3, 7));
        System.out.println(combinationSum.combinationSum3(3, 9));
        System.out.println(combinationSum.combinationSum3(3, 1));

        System.out.println("\nCombination Sum 4");
        System.out.println(combinationSum.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(combinationSum.combinationSum4(new int[]{9}, 3));
        System.out.println(combinationSum.combinationSum4(new int[]{4, 2, 1}, 32));
        System.out.println(combinationSum.combinationSum4(new int[]{2, 1, 3}, 35));
        System.out.println(combinationSum.combinationSum4(new int[]{4, 2, 1, 5, 11}, 28));
    }
}
