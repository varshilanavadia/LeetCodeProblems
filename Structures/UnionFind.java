public class UnionFind {
    int[] root; // stores the root of each vertex
    int[] rank; // stores the height of each vertex

    public UnionFind(int size) {
        this.root = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(x == root[x]){
            return x;
        }
        return x = find(root[x]);
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(rank[x] > rank[y]){
                // x has a higher rank (height) than x, so connect y to x
                root[rootY] = rootX;
            } else if(rank[x] < rank[y]){
                // y has a higher rank (height) than y, so connect x to y
                root[rootX] = rootY;
            } else {
                // both x and y have same rank so connect one to another and increase rank/height
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            return true;
        }
        return false;
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
