public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
    	int len = num.length;
    	if(len == 0) return null;
    	return sort(num, 0 , len-1);
    }

    public TreeNode sort(int[] num, int lh, int rh) {
    	if(lh > rh) return null;
    	int mid = lh + (rh - lh)/2;
    	TreeNode t = new TreeNode(num[mid]);
    	t.left = sort(num, lh, mid-1);
    	t.right = sort(num, mid+1, rh);
    	return t;
    }
}