public class Sol1335 {
    public static void main(String[] args) {
        ConnectCities connectCities = new ConnectCities();

        System.out.println(connectCities.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
        System.out.println(connectCities.minimumCost(4, new int[][]{{1,2,3},{3,4,4}}));

    }
}