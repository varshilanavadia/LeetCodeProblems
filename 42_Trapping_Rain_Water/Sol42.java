public class Sol42 {
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int[][] heights = {{0,1,0,2,1,0,1,3,2,1,2,1}, {4,2,0,3,2,5}};

        for(int[] height : heights) {
            System.out.println(trappingRainWater.trap_using_dp(height));
            System.out.println(trappingRainWater.trap_using_2ptr(height));
        }

        int[][][] heightMaps = {{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}},
                {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}};

        for(int[][] heightMap : heightMaps){
            System.out.println(trappingRainWater.trapRainWater2(heightMap));
        }
        
    }
}
