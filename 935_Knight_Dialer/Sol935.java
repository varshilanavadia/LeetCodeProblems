public class Sol935 {
    public static void main(String[] args) {
        KnightDialer knightDialer = new KnightDialer();

        System.out.println(knightDialer.knightDialer(10));
//        System.out.println(knightDialer.knightDialer(3131));

        int x = 1;
        while (x <= 2000){
            System.out.println(x + ": " + knightDialer.knightDialer(x));
            x++;
        }

    }
}
