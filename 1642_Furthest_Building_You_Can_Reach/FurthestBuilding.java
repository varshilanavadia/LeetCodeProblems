import java.util.PriorityQueue;

public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;

        for(int i = 0; i < n-1; i++){
            int climb = heights[i+1] - heights[i];
            if(climb > 0){
                pq.offer(climb);
                ladders--;
                if(ladders < 0){
                    bricks -= pq.remove();
                    if(bricks < 0){
                        return i;
                    }
                    ladders++;
                }
            }
        }
        return n-1;
    }
}