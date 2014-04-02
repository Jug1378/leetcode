public class Solution {
	/*
	iterative method
	time O(N)
	 */
    public void flatten(TreeNode root) {
        while(root != null) {
        	if(root.left != null) {
        		TreeNode head = root;
        		TreeNode temp = head.right;
        		head.right = head.left;
        		head.left = null;
        		while(head.right != null)
        			head = head.right;
        		head.right = temp;
        	}
        	root = root.right;
        }
    }

    /*
    recursive method
     */
    public void flatten2(TreeNode root) {
    	if(root == null) return;
    	doFlatten(root);
    }

    public TreeNode doFlatten(TreeNode root) {
    	if(root == null) return null;
    	TreeNode tempRight = doFlatten(root.right);
    	root.right = doFlatten(root.left);
    	TreeNode tempRoot = root;
    	while(tempRoot.right != null)
    		tempRoot = tempRoot.right;
    	tempRoot.right = tempRight;
    	return root;
    }
}