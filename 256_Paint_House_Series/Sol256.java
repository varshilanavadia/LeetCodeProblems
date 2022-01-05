public class Sol256 {
    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();

        int[][][] costs = new int[][][]{{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}
                                        , {{1,5,3},{2,9,4}}};

        for(int[][] cost: costs){
            System.out.println(paintHouse.minCost(cost));
            System.out.println(paintHouse.minCostII(cost));
        }

    }
}
