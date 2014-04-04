public class Solution {
	/*
	not use a single height function to count the height of node
	but just combine the determintion and height-count to save time
	 */
    public boolean isBalanced(TreeNode root) {
        int h = height(root);
        if(h == - 1) return false;
        else return true;
    }

    public int height(TreeNode root) {
    	if(root == null) return 0;
    	int left = height(root.left);
    	int right = height(root.right);
    	if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
    	return 1 + Math.max(left, right);
    }
}