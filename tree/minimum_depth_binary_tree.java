public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right != null)
        	return 1 + Math.min(minDepth(root.right), minDepth(root.left));
        return 1 + minDepth(root.left)+minDepth(root.right);
    }
}