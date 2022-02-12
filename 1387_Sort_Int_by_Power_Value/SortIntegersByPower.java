import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntegersByPower {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int getKth(int lo, int hi, int k) {

            // number, power of number
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
            for (int i = lo; i <= hi; i++) {
                heap.offer(new int[]{i, powerOf(i)});
                if (heap.size() > k) {
                    heap.poll();
                }
            }

            return heap.poll()[0];
        }

        private int powerOf(int n) {
            if (n == 1) {
                return 0;
            }

            if (map.containsKey(n)) {
                return map.get(n);
            }

            if ((n & 1) == 0) {
                map.put(n, powerOf(n / 2) + 1);
            } else {
                map.put(n, powerOf(3 * n + 1) + 1);
            }

            return map.get(n);
        }
    }
}