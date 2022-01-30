public class MedianSortedArr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length; // 2, 2
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = m; // 0, 2

        while(left <= right){
            int p1 = (left+right)/2; // 1
            int p2 = (m+n+1)/2 - p1; // 1

            int p1Left = p1 == 0 ? Integer.MIN_VALUE : nums1[p1-1]; //
            int p1Right = p1 == m ? Integer.MAX_VALUE : nums1[p1]; //
            int p2Left = p2 == 0 ? Integer.MIN_VALUE : nums2[p2-1]; //
            int p2Right = p2 == n ? Integer.MAX_VALUE : nums2[p2]; //

            if(p1Left <= p2Right && p2Left <= p1Right){
                if((m+n) % 2 == 0){
                    return (double) (Math.max(p1Left, p2Left) + Math.min(p1Right, p2Right))/2;
                } else {
                    return (double) Math.max(p1Left, p2Left);
                }
            } else if (p1Left > p2Right){
                right = p1 - 1;
            } else {
                left = p1 + 1;
            }
        }
        return 0;
    }
}