public class Sol787 {
    public static void main(String[] args) {
        CheapestFlights cheapestFlights = new CheapestFlights();

        System.out.println(cheapestFlights.findCheapestPrice_dfs_withMemo(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},0, 2, 1));
        System.out.println(cheapestFlights.findCheapestPrice_dfs_withMemo(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},0, 2, 1));

    }
    
}
