import java.util.Arrays;

public class Sol973 {
    public static void main(String[] args) {
        KClosestToOrigin kClosestToOrigin = new KClosestToOrigin();

        System.out.println(Arrays.deepToString(kClosestToOrigin.kClosest_usingHeap(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(kClosestToOrigin.kClosest_usingHeap(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
        System.out.println(Arrays.deepToString(kClosestToOrigin.kClosest_usingHeap(new int[][]{{-5, 4}, {-6, -5}, {4, 6}}, 2)));

        System.out.println(Arrays.deepToString(kClosestToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(kClosestToOrigin.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
        System.out.println(Arrays.deepToString(kClosestToOrigin.kClosest(new int[][]{{-5, 4}, {-6, -5}, {4, 6}}, 2)));
    }
}
