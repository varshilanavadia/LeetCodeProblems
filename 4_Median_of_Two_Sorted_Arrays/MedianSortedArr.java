public class MedianSortedArr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length, m = nums2.length;
        int start = 0, end = n;

        while(start <= end){
            int partition1 = (start+end)/2;
            int partition2 = (n+m+1)/2 - partition1;

            int p1Left = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1-1];
            int p1Right = partition1 == n ? Integer.MAX_VALUE : nums1[partition1];
            int p2Left = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2-1];
            int p2Right = partition2 == m ? Integer.MAX_VALUE : nums2[partition2];

            if(p1Left <= p2Right && p2Left <= p1Right){
                if((n + m) % 2 == 0){
                    return (double) (Math.max(p1Left, p2Left) + Math.min(p1Right, p2Right))/2;
                } else {
                    return (double) Math.max(p1Left, p2Left);
                }
            } else if(p1Left > p2Right){
                end = partition1 - 1;
            } else {
                start = partition1 + 1;
            }
        }
        return 0;
    }
}