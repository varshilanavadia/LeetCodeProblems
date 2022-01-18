import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestToOrigin {
    public int[][] kClosest_usingHeap(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point: points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[k][];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }

        return result;
    }

    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k);
    }

    private int[][] quickSelect(int[][] points, int k){
        int left = 0, right = points.length - 1;

        while(left < right){
            int pivot = partition(points, left, right);

            if(pivot == k){
                break;
            } else if (pivot < k){
                left = pivot+1;
            } else {
                right = pivot-1;
            }
        }

        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right){
        int pivot = right;
        int i = left;
        for(int j = left; j < right; j++){
            if(distance(points, j, pivot) < 0){
                swap(points, i, j);
            }
        }

        swap(points, i, pivot);
        return i;
    }

    private int distance(int[][] points, int j, int pivot){
        int[] point1 = points[j];
        int[] point2 = points[pivot];

        int distance1 = point1[0]*point1[0] + point1[1]*point1[1];
        int distance2 = point2[0]*point2[0] + point2[1]*point2[1];

        return distance1 - distance2;
    }

    private void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
