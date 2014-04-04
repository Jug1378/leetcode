public class Solution {
	/*
	return the total number of unique BST
	 */
    public int numTrees(int n) {
    	return count(1,n);
    }

    public int count(int min, int max) {
    	if(min >= max) return 1;
    	int total = 0;
    	for(int i=min; i<=max; i++) {
    		total += count(min, i-1) * count(i+1, max);
    	}
    	return total;
    }


    /*
    return the total unique BST
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public ArrayList<TreeNode> generate(int min, int max) {
    	ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
    	if(min > max)
    		arr.add(null);
    	else if(min == max)
    		arr.add(new TreeNode(min));
    	else {
    		for(int i=min; i<=max; i++) {
    			ArrayList<TreeNode> left = generate(min, i-1);
    			ArrayList<TreeNode> right = generate(i+1, max);
    			for(TreeNode l:left)
    				for(TreeNode r:right) {
    					TreeNode t = new TreeNode(i);
    					t.left = l;
    					t.right = r;
    					arr.add(t);
    				}
    		}
    	}
    	return arr;
    }
}