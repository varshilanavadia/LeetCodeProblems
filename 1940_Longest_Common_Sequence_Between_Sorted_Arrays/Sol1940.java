public class Sol1940 {
    public static void main(String[] args) {
        LCSinArrays lcSinArrays = new LCSinArrays();
        
        int[][][] arrays = new int[][][]{
                                            {{2,3,6,8}, {1,2,3,5,6,7,10}, {2,3,4,6,9}},
                                            {{1,3,4}, {1,4,7,9}},
                                            {{1,2,3,4,5}, {6,7,8}}
                                        };
        
        for(int[][] array : arrays){
            System.out.println(lcSinArrays.longestCommonSubsequence(array));
            System.out.println(lcSinArrays.longestCommonSubsequence_usingHashSet(array));
            System.out.println(lcSinArrays.longestCommonSubsequence_usingHashMap(array));
        }

    }
}
