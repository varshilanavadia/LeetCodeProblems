public class Sol1642 {
    public static void main(String[] args) {
        FurthestBuilding furthestBuilding = new FurthestBuilding();

        System.out.println(furthestBuilding.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        System.out.println(furthestBuilding.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
        System.out.println(furthestBuilding.furthestBuilding(new int[]{14,3,19,3}, 17, 0));
    }
}
