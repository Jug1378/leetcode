public class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean valid(TreeNode root, int min, int max) {
    	if(root == null) return true;
    	if(root.val >= max || root.val <= min) return false;
    	return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
}