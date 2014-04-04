public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int l1 = preorder.length;
    	int l2 = inorder.length;
    	return build(preorder, 0, l1-1, inorder, 0, l2-1);
    }

    public TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
    	if(pl > pr || il > ir) return null;
    	int head = preorder[pl];
    	int k = 0;
    	TreeNode root = new TreeNode(head);
    	for(int i = il; i <= ir; i++) {
    		if(inorder[i] == head)
    			{
    				k = i;
    				break;
    			}
    	}
    	root.left = build(preorder, pl+1, pl+k-il, inorder, il, k-1);
    	root.right = build(preorder, pl+k-il+1, pr, inorder, k+1, ir);
    	return root;
    }
}