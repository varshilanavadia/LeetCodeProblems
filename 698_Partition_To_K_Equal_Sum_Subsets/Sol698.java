public class Sol698 {
    public static void main(String[] args) {
        PartitionSubsets partitionSubsets = new PartitionSubsets();

        System.out.println(partitionSubsets.canPartitionKSubsets1(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));

        System.out.println(partitionSubsets.canPartition(new int[]{1, 5, 11, 5}));

    }
}
