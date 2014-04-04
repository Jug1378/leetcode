public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if(root == null) return arr;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int current = 1;
        int next = 0;
        boolean bool = true;
        q.add(root);
        while(!q.isEmpty()) {
        	TreeNode t = q.poll();
        	temp.add(t.val);
        	if(t.left != null) {
        		q.add(t.left);
        		next++;
        	}
        	if(t.right != null) {
        		q.add(t.right);
        		next++;
        	}
        	if(--current == 0) {
                if(!bool)
                    Collections.reverse(temp);
                bool = !bool;
        		arr.add(new ArrayList<Integer>(temp));
        		current = next;
        		next = 0;
        		temp.clear();
        	}
        }
        return arr;
    }
}