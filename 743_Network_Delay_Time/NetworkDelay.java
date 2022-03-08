import javafx.util.Pair;

import java.util.*;

public class NetworkDelay {
    Map<Integer, List<Pair<Integer, Integer>>> graph;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.graph = new HashMap<>();
        for(int[] time: times){
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] signalReachedAt = new int[n];
        Arrays.fill(signalReachedAt, Integer.MAX_VALUE);

        djikstrasBFS(n, signalReachedAt, k);

        int maxTime = Integer.MIN_VALUE;
        for(int time: signalReachedAt){
            maxTime = Math.max(maxTime, time);
        }
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }

    private void djikstrasBFS(int n, int[] signalReachedAt, int node) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );

        pq.offer(new Pair<>(node, 0));
        signalReachedAt[node-1] = 0;

        while(!pq.isEmpty()){
            Pair<Integer, Integer> current = pq.poll();
            int currNode = current.getKey();
            int currTime = current.getValue();

            if(!graph.containsKey(currNode)){
                continue;
            }

            if(currTime > signalReachedAt[currNode-1]){
                continue;
            }

            for (Pair<Integer, Integer> next: graph.get(currNode)){
                int nextNode = next.getKey();
                int nextTime = next.getValue();
                int reachableTime = nextTime + currTime;
                if(signalReachedAt[nextNode-1] > reachableTime){
                    signalReachedAt[nextNode-1] = reachableTime;
                    pq.offer(new Pair(nextNode, reachableTime));
                }
            }
        }
    }

    public static void main(String[] args) {
        NetworkDelay obj = new NetworkDelay();

        System.out.println(obj.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        System.out.println(obj.networkDelayTime(new int[][]{{1,2,1}}, 2, 1));
        System.out.println(obj.networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
    }
}
