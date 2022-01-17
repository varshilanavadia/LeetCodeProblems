import java.util.Arrays;

public class Sol31 {
    public static void main(String[] args) {
        NextPerm nextPerm = new NextPerm();

        System.out.println(Arrays.toString(nextPerm.nextPermutation(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(nextPerm.nextPermutation(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(nextPerm.nextPermutation(new int[]{1,5,8,4,7,6,5,3,1})));
    }
}
