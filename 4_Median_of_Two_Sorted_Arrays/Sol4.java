public class Sol4 {
    public static void main(String[] args) {
        MedianSortedArr medianSortedArr = new MedianSortedArr();

        System.out.println(medianSortedArr.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(medianSortedArr.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(medianSortedArr.findMedianSortedArrays(new int[]{1,3,8,9,15}, new int[]{2,4,7,12,17,21}));
    }
}
