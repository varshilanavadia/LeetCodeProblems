public class Sol300 {
    public static void main(String[] args) {
        LIS lis = new LIS();

        System.out.println(lis.lengthOfLIS_dymanic_programming(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
