public class Sol2093 {
    public static void main(String[] args) {
        MinCostToReachWithDiscounts minCostToReachWithDiscounts = new MinCostToReachWithDiscounts();

        System.out.println(minCostToReachWithDiscounts.minimumCost(6, new int[][]{{0,1,2},{1,3,4},{0,2,6},{2,3,8},{3,4,100},{4,5,200}}, 2));
        System.out.println(minCostToReachWithDiscounts.minimumCost(5, new int[][]{{0,1,4},{2,1,3},{1,4,11},{3,2,3},{3,4,2}}, 1));
        System.out.println(minCostToReachWithDiscounts.minimumCost(2, new int[][]{{1,0,0}}, 0));
        System.out.println(minCostToReachWithDiscounts.minimumCost(4, new int[][]{{1,3,17},{1,2,7},{3,2,5},{0,1,6},{3,0,20}}, 20));
    }
}