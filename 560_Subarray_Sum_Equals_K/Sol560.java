public class Sol560 {
    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();

        System.out.println(subArraySumEqualsK.subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7));
        System.out.println(subArraySumEqualsK.subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subArraySumEqualsK.subarraySum(new int[]{1,2,3}, 3));
    }
}
