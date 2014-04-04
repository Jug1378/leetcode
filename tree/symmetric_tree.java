public class Solution {
	/*
	recursively
	 */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode t1, TreeNode t2) {
    	if(t1 == null && t2 == null) return true;
    	if(t1 == null || t2 == null) return false;
    	return (t1.val == t2.val) && isSym(t1.left, t2.right) && isSym(t1.right, t2.left);
    }

    /*
    iteratively with two queues
     */
    public boolean isSymmetric2(TreeNode root) {
    	if(root == null) return true;
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> q2 = new LinkedList<TreeNode>();
    	q1.add(root.left);
    	q2.add(root.right);
    	while(!q1.isEmpty() && !q2.isEmpty()) {
    		TreeNode t1 = q1.poll();
    		TreeNode t2 = q2.poll();
    		if(t1 == null && t2 == null) continue;
    		if(t1 == null || t2 == null || t1.val != t2.val) return false;
    		q1.add(t1.left);
    		q2.add(t2.right);
    		q1.add(t1.right);
    		q2.add(t2.left);
    	}
    	return true;
    }

    /*
    iteratively with one stack
     */
    public boolean isSymmetric3(TreeNode root) {
    	if(root == null) return true;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root.left);
    	s.push(root.right);
    	while(!s.isEmpty()) {
    		TreeNode t1 = s.pop();
    		TreeNode t2 = s.pop();
    		if(t1 == null && t2 == null) continue;
    		if(t1 == null || t2 == null || t1.val != t2.val) return false;
    		s.push(t1.left);
    		s.push(t2.right);
    		s.push(t1.right);
    		s.push(t2.left);
    	}
    	return true;
    }
}