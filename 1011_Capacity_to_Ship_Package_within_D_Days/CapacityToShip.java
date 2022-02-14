public class CapacityToShip {
    public int shipWithinDays(int[] weights, int days) {
        int minWeight = 0, maxWeight = 0, result = 0;
        for(int w: weights){
           minWeight = Math.max(minWeight, w);
           maxWeight += w;
        }

        while(minWeight <= maxWeight){
            int mid = minWeight + (maxWeight - minWeight)/2;
            int daysReqd = shipWeightsWithCapacity(weights, mid);
            if(daysReqd > days){
                minWeight = mid + 1;
            } else{
                result = mid;
                maxWeight = mid - 1;
            }
        }

        return result;
    }

    private int shipWeightsWithCapacity(int[] weights, int capacity) {
        int currCapacity = 0, daysReqd = 1;
        for(int w: weights){
            currCapacity += w;
            if(currCapacity > capacity){
                currCapacity = w;
                daysReqd++;
            }
        }
        return daysReqd;
    }
}
