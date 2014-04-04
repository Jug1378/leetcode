public class Solution {
	/*
	have to make a private instance variable copy of ListNode head
	 */
    private static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        int len = length(head);
        h = head;
        return sort(0, len-1);
    }

    public int length(ListNode head) {
    	int len = 0;
    	while(head != null) {
    		len++;
    		head = head.next;
    	}
    	return len;
    }

    public TreeNode sort(int lh, int rh) {
    	if(lh > rh) return null;
    	int mid = lh + (rh - lh)/2;
    	TreeNode left = sort(lh, mid-1);
    	TreeNode root = new TreeNode(h.val);
    	h = h.next;
    	TreeNode right = sort(mid+1, rh);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}