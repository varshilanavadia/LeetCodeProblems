import java.util.Arrays;

public class Sol347 {
    public static void main(String[] args) {
        TopKFreq topKFreq = new TopKFreq();

        System.out.println(Arrays.toString(topKFreq.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 3, 3, 4}, 2)));

        System.out.println(Arrays.toString(topKFreq.topKFrequent_using_quickSelect(new int[]{1, 1, 1, 2, 2, 3, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 3, 3, 4}, 2)));

    }
}
