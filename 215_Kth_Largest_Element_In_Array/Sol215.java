public class Sol215 {
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();

        System.out.println(kthLargestElement.findKthLargestUsingHeap(new int[]{3, 2, 4, 6, 1, 5}, 2));
        System.out.println(kthLargestElement.findKthLargestUsingQuickSelect(new int[]{3, 2, 4, 6, 1, 5}, 2));
    }
}
