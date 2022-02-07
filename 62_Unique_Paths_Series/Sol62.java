public class Sol62 {
    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();

        System.out.println(uniquePath.uniquePaths(3, 7));
        System.out.println(uniquePath.uniquePaths(3, 17));
        System.out.println(uniquePath.uniquePaths(43, 4));
        System.out.println(uniquePath.uniquePaths(19, 5));

        System.out.println(uniquePath.uniquePathsWithObstacles(new int[][]{{0,0,0,0,0}, {0,0,0,0,1}, {0,0,0,1,0}, {0,0,1,0,0}}));
    }
}
