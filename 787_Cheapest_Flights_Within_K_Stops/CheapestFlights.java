import javafx.util.Pair;

import java.util.*;

public class CheapestFlights {

    /*
    * APPROACH 1
    * Less Efficient Implementation of Dijkstra's Algorithm in O(V^2 Log(V)) time
    * */
    public int findCheapestPrice_naive_dijkstras(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for(int[] flight: flights){
            graph[flight[0]][flight[1]] = flight[2];
        }

        int[] minCost = new int[n];
        int[] numStops = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        Arrays.fill(numStops, Integer.MAX_VALUE);
        minCost[src] = 0;
        numStops[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // city, minCost to city, num stops to city
        pq.offer(new int[]{src, 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int city = curr[0], cost = curr[1], stops = curr[2];

            if(city == dst){
                return cost;
            }

            if(stops == k+1){
                continue;
            }

            for(int j = 0; j < n; j++){
                if(graph[city][j] > 0){
                    int costToNext = graph[city][j];
                    if(costToNext + cost < minCost[j]){
                        pq.offer(new int[]{j, costToNext + cost, stops+1});
                        minCost[j] = costToNext + cost;
                    } else if(stops < numStops[j]){
                        pq.offer(new int[]{j, costToNext + cost, stops+1});
                    }
                    numStops[j] = stops;
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public int findCheapestPrice_using_list(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<int[]>();
        }

        for(int[] flight: flights){
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{src, 0, 0});

        int[] minCosts = new int[n];
        int[] minStops = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        Arrays.fill(minStops, Integer.MAX_VALUE);
        minCosts[src] = 0;
        minStops[src] = 0;

        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int city = current[0], cost = current[1], stops = current[2];
            if(city == dst){
                return cost;
            }
            if(stops == k+1){
                continue;
            }

            for(int[] next: graph[city]){
                int costToNext = next[1];
                if(cost + costToNext < minCosts[next[0]]){
                    heap.offer(new int[]{next[0], cost+costToNext, stops+1});
                    minCosts[next[0]] = cost + costToNext;
                } else if (stops < minStops[next[0]]){
                    heap.offer(new int[]{next[0], cost+costToNext, stops+1});
                }
                minStops[next[0]] = stops;
            }
        }

        return minCosts[dst] == Integer.MAX_VALUE ? -1 : minCosts[dst];
    }

    /*
    * APPROACH 2
    * DFS with Memoization in O(VK) time
    * */
    public int findCheapestPrice_dfs_withMemo(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for(int[] flight: flights){
            graph[flight[0]][flight[1]] = flight[2];
        }

        Map<Pair<Integer, Integer>, Long> map = new HashMap<>();

        long minCost = dfs(graph, map, src, dst, k, n);
        return minCost >= Integer.MAX_VALUE ? -1 : (int) minCost;
    }

    private long dfs(int[][] graph, Map<Pair<Integer, Integer>, Long> map, int node, int dest, int stops, int n){
        if(node == dest){
            return 0;
        }

        if(stops < 0){
            return Integer.MAX_VALUE;
        }

        Pair<Integer, Integer> key = new Pair<>(node, stops);
        if(map.containsKey(key)){
            return map.get(key);
        }

        long dist = Integer.MAX_VALUE;
        for(int next = 0; next < n; next++){
            if(graph[node][next] > 0){
                dist = Math.min(dist, graph[node][next] + dfs(graph, map, next, dest, stops-1, n));
            }
        }
        map.put(key, dist);
        return dist;
    }


}
