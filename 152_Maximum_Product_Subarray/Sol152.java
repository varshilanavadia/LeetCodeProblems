public class Sol152 {
    public static void main(String[] args) {
        MaxProdSubarray maxProdSubarray = new MaxProdSubarray();

        System.out.println(maxProdSubarray.maxProduct_naive(new int[]{2, 3, -2, 4}));
        System.out.println(maxProdSubarray.maxProduct(new int[]{2, 3, -2, 4}));

    }
}
