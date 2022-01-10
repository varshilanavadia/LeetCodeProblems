public class Sol1059 {
    public static void main(String[] args) {
        LeadsToDestination leadsToDestination = new LeadsToDestination();

        System.out.println(leadsToDestination.leadsToDestination(3, new int[][]{{0, 1},{0, 2}}, 0, 2));
        System.out.println(leadsToDestination.leadsToDestination(4, new int[][]{{0, 1},{0, 3}, {1, 2}, {2, 1}}, 0, 3));
        System.out.println(leadsToDestination.leadsToDestination(4, new int[][]{{0, 1},{0, 2}, {1, 3}, {2, 3}}, 0, 3));
    }
}
