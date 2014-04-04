public class Solution {
	/*
	need two pointer to store the swapped elements
	 */
	private TreeNode prev = null;
	private TreeNode first = null;
	private TreeNode second = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public void inorder(TreeNode root) {
    	if(root == null) return;
    	inorder(root.left);
    	if(prev == null)
    		prev = root;
    	else {
    		if(root.val < prev.val) {
    			if(first == null) // store the first wrong node
    				first = prev;
    			second = root;    // store the second wrong node, but not use ELSE, which
    							  // would not apply in situation with only two nodes
    		}
    		else
    			prev = root;
    	}
    	inorder(root.right);
    }
}