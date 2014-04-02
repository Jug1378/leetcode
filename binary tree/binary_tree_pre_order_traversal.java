public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(root == null) return arr;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
        	TreeNode t = s.pop();
        	arr.add(t.val);
        	if(t.right != null) s.push(t.right);
        	if(t.left != null) s.push(t.left);
        }
        return arr;
    }
}