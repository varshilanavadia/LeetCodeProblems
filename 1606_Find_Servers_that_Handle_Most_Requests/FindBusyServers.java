import java.util.*;

public class FindBusyServers {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        // PQ to store end time of a task as well as ID of assigned server to complete task
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // int[] to maintain the number of tasks handled by each server
        int[] busyCounter = new int[k];

        // Ordered set to maintain which server is available currently
        TreeSet<Integer> availableServers = new TreeSet<>();
        for(int i = 0; i < k; i++){
            availableServers.add(i);
        }

        for(int i = 0; i < arrival.length; i++){
            // Find out arrival and end times of current task
            int arrivalTime = arrival[i];
            int loadTime = load[i];
            int endTime = arrivalTime + loadTime;

            // Complete any tasks in queue before current arrival time and free servers
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= arrivalTime){
                int freedServer = busyServers.poll()[1];
                availableServers.add(freedServer);
            }

            // If a server is busy, drop the task
            if(availableServers.size() == 0){
                continue;
            }

            // Find out assigned server to current task depending on priority
            // TreeSet.ceiling() finds the least element in set greater than or equal to parameter passed
            // If such an element does not exist, it returns null
            Integer assignedServerId = availableServers.ceiling(i%k);
            if(assignedServerId == null){
                assignedServerId = availableServers.first(); // no server assigned, grab the first one available
            }
            // Increase task counter of this server
            busyCounter[assignedServerId]++;

            // Make server unavailable by removing from set, that is assign a task
            availableServers.remove(assignedServerId);

            // Add task with end time and server id to PQ
            busyServers.offer(new int[]{endTime, assignedServerId});
        }

        // Find busiest servers
        return maxFromBusyCounters(busyCounter);
    }

    private List<Integer> maxFromBusyCounters(int[] busyCounter){
        Integer max = Integer.MIN_VALUE;
        for(int count: busyCounter){
            max = Math.max(count, max);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < busyCounter.length; i++){
            if(busyCounter[i] == max){
                result.add(i);
            }
        }
        return result;
    }


}
