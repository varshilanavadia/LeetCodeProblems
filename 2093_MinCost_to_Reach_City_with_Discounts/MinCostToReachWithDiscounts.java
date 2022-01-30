import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToReachWithDiscounts {
    public int minimumCost(int n, int[][] highways, int discounts) {
        ArrayList<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<int[]>();
        }
        for(int[] highway: highways){
            graph[highway[0]].add(new int[]{highway[1], highway[2]});
            graph[highway[1]].add(new int[]{highway[0], highway[2]});
        }

        int[][] minCosts = new int[n][discounts+1];
        for(int[] minCost: minCosts){
            Arrays.fill(minCost, Integer.MAX_VALUE);
        }
        minCosts[0][0] = 0;

        // city, cost, discounts
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{0, 0, 0});

        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int city = current[0], cost = current[1], discountsUsed = current[2];

            if(city == n-1){
                return cost;
            }

            for(int[] next: graph[city]){
                int costToNext = next[1];

                int costWithoutDiscount = cost + costToNext;
                int costWithDiscount = cost + costToNext/2;

                if(costWithoutDiscount < minCosts[next[0]][discountsUsed]){
                    heap.offer(new int[]{next[0], costWithoutDiscount, discountsUsed});
                    minCosts[next[0]][discountsUsed] = costWithoutDiscount;
                }

                if(discountsUsed < discounts && costWithDiscount < minCosts[next[0]][discountsUsed+1]){
                    heap.offer(new int[]{next[0], costWithDiscount, discountsUsed+1});
                    minCosts[next[0]][discountsUsed+1] = costWithDiscount;
                }
            }
        }

        return -1;
    }
}
