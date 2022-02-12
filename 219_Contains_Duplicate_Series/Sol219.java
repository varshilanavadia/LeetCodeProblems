public class Sol219 {
    public static void main(String[] args) {
        ContainsDup containsDup = new ContainsDup();

        System.out.println(containsDup.containsNearDup(new int[]{1,2,3,1}, 3));
        System.out.println(containsDup.containsNearDup(new int[]{1,2,3,1,2,3}, 2));
        System.out.println(containsDup.containsNearDup(new int[]{1,2,3,1}, 3,0));
        System.out.println(containsDup.containsNearDup(new int[]{1,5,9,1,5,9}, 2,3));
    }
}
