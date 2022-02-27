public class Sol55 {
    public static void main(String[] args) {

        JumpGame jumpGame = new JumpGame();

        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame.canJump(new int[]{2,3,0,1,4}));

        System.out.println(jumpGame.minJump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame.minJump(new int[]{2,3,1,0,4,1,6,9,3,1,1,1,0,4,3,1,0,2,4}));
        System.out.println(jumpGame.minJump(new int[]{2,3,0,1,4}));

    }
}
