public class Sol198 {
    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();

        System.out.println(houseRobber.rob_1_topDownDP(new int[]{1, 2, 3, 1}));
        System.out.println(houseRobber.rob_1_bottomUpDP(new int[]{1, 2, 3, 1}));
        System.out.println(houseRobber.rob_2(new int[]{1, 2, 3, 1}));

    }
}
