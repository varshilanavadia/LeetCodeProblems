public class Sol787 {
    public static void main(String[] args) {
        CheapestFlights cheapestFlights = new CheapestFlights();

        System.out.println(cheapestFlights.findCheapestPrice_dfs_withMemo(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},0, 2, 1));
        System.out.println(cheapestFlights.findCheapestPrice_dfs_withMemo(3, new int[][]{{0,1,100},{1,2,100},{0,2,
                500}},0, 2, 0));


        System.out.println(cheapestFlights.findCheapestPrice_djikstra_usingMap(9, new int[][]{{0,1,1},{1,2,1},{2,3,1},{3,7,1},{0,4,3},{4,5,3},{5,7,3},
                {0,6,5},{6,7,100},{7,8,1}},0, 8, 3));

    }
}