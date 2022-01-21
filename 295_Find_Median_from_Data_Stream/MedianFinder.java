import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }

    public void addNum(int num){
        // add num  to lower half
        lowerHalf.add(num);

        // since we just added one element to lower half, its size increased so re-balance
        // by adding top of lowerHalf to upperHalf
        upperHalf.add(lowerHalf.poll());

        // lower half can't have fewer elements than upper half to balance both sides
        // if so, re-balance by adding top of upperHalf to lowerHalf
        if(lowerHalf.size() > upperHalf.size()){
            lowerHalf.add(upperHalf.poll());
        }
    }

    public double findMedian(){
        return lowerHalf.size() > upperHalf.size() ? lowerHalf.peek() : (double) (lowerHalf.peek() + upperHalf.peek())/2;
    }
}
