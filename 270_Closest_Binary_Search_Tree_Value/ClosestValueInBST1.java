public class ClosestValueInBST1{
    public int closestValue(TreeNode root, double target) {

        if(root.left == null && root.right == null){
            return root.value;
        }

        if(root.value < target){
            if(root.right == null) return root.value;

            double diff1 = Math.abs(root.value - target);
            int ret = closestValue(root.right, target);
            double diff2 = Math.abs(ret - target);

            return diff1 > diff2 ? ret : root.value;
        } else if(root.value > target){
            if(root.left == null) return root.value;

            double diff1 = Math.abs(root.value - target);
            int ret = closestValue(root.left, target);
            double diff2 = Math.abs(ret - target);

            return diff1 > diff2 ? ret : root.value;
        }
        return root.value;
    }
}
