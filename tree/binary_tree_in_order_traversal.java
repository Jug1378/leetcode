public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(root == null) return arr;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(true) {
        	if(cur != null) {
        		s.push(cur);
        		cur = cur.left;
        	}
        	else {
        		if(!s.isEmpty()) {
        			cur = s.pop();
        			arr.add(cur.val);
        			cur = cur.right;
        		}
        		else
        			break;
        	}
        }
        return arr;
    }
}