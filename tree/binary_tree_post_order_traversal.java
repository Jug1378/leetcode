public class Solution {
	/*
	recursively
	 */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        post(root, arr);
        return arr;
    }

    public void post(TreeNode root, ArrayList<Integer> arr) {
    	if(root == null) return;
    	post(root.left, arr);
    	post(root.right, arr);
    	arr.add(root.val);
    }


    /*
    iteratively
     */
    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	if(root == null) return arr;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	TreeNode prev = root;
    	while(!s.isEmpty()) {
    		TreeNode t = s.peek();
    		if(t.right == prev || t.left == prev || t.right == null && t.left == null) {
    			arr.add(t.val);
    			prev = s.pop();
    		}
    		else {
    			if(t.right != null) s.push(t.right);
    			if(t.left != null) s.push(t.left);
    		}
    	}
    	return arr;
    }
}