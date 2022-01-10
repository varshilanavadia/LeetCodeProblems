public class Sol1091 {
    public static void main(String[] args) {
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        
        int[][][] matrices = new int[][][]{
                {{0,0,0},{1,1,0},{1,1,0}},
                {{1,0,0},{1,1,0},{1,1,0}},
                {{0,1},{1,0}},
                {{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}}
        };

        for(int[][] matrix : matrices){
            System.out.println(shortestPathInBinaryMatrix.shortestPathBinaryMatrix(matrix));
        }
    }
}
