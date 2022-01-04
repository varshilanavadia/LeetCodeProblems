public class Sol53 {
    public static void main(String[] args) {
        MaxSubarray maxSubarray = new MaxSubarray();

        System.out.println(maxSubarray.maxSubArray(new int[]{-2, -1, -3, 4, -1, 2, 1, -1}));

        System.out.println(maxSubarray.maxSubArray_naive(new int[]{-2, -1, -3, 4, -1, 2, 1, -1}));
    }
}
