public class Sol1971 {
    public static void main(String[] args) {
        FindPathBetweenVertices findPathBetweenVertices = new FindPathBetweenVertices();

        System.out.println(findPathBetweenVertices.validPath_BFS(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println(findPathBetweenVertices.validPath_DFS(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));


        System.out.println(findPathBetweenVertices.validPath_BFS(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
        System.out.println(findPathBetweenVertices.validPath_DFS(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));

    }
}
