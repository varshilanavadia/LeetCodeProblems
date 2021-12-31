import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Sol170 {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        System.out.println(Arrays.toString(twoSum.twoSum1(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum1(new int[]{2, 7, 11, 15}, 10)));
        System.out.println(Arrays.toString(twoSum.twoSum1(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum1(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum1(new int[]{-1, 0}, -1)));

        System.out.println();

        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{2, 7, 11, 15}, 10)));
        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{3, 4}, 7)));
        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{-1, 0}, -1)));

        System.out.println();

        System.out.println(twoSum.add(1));
        System.out.println(twoSum.add(3));
        System.out.println(twoSum.add(5));
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));


    }
}
