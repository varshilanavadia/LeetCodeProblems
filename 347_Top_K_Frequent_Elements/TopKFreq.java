import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreq {

    // Using heap
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));

        for(int key: map.keySet()){
            heap.offer(key);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(i < k){
            result[i++] = heap.remove();
        }

        return result;
    }

    // Using Quick Select (Hoare's selection) algorithm
    public int[] topKFrequent_using_quickSelect(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map.entrySet());

        int n = map.size(), i = 0;
        int[] array = new int[n];
        for(int num: map.keySet()){
            array[i++] = num;
        }
        System.out.println(Arrays.toString(array));
        quickSelect(array, 0, n-1, k, map);
        System.out.println(Arrays.toString(array));

        return Arrays.copyOf(array, k);
    }

    private void quickSelect(int[] array, int left, int right, int k, Map<Integer, Integer> map) {
        if(left >=  right){
            return;
        }

        int pivotIndex = partition(array, left, right, map);

        if(k < pivotIndex){
            quickSelect(array, left, pivotIndex-1, k, map);
        } else if(k > pivotIndex){
            quickSelect(array, pivotIndex+1, right, k, map);
        }
    }

    private int partition(int[] array, int left, int right, Map<Integer, Integer> map) {
        int pivotFreq = map.get(array[right]);
        int i = left;
        for(int j = left; j < right; j++){
            int numFreq = map.get(array[j]);
            if(numFreq > pivotFreq){
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
