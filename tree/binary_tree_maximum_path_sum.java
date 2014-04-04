public class Solution {
    public int maxPathSum(TreeNode root) {
    	if(root == null) return -1;
    	int[] max = new int[1];
    	max[0] = Integer.MIN_VALUE;
    	findMax(root, max);
    	return max[0];
    }

    public int findMax(TreeNode root, int[] max) {
    	if(root == null) return 0;
    	int left = findMax(root.left);
    	int right = findMax(root.right);
    	int cur = Math.max(root.val, Math.max(root.val+left, root.val+right));
    	max[0] = Math.max(max[0], Math.max(cur, root.val+left+right));
    	return cur;
    }
}