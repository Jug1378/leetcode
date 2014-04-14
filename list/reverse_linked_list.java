public class Solution {
	/*
	simple version
	just insert the node one by one
	prevM: the node before m
	prev: the last node of reversed nodes
	curr: the one to insert after prevM
	 */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevM = dummy, prev, curr;
        for(int i=1; i<=n; i++) {
        	if(i<m)
        		prevM = prevM.next;
        	else if(i == m) {
        		prev = prevM.next;
        		curr = prev.next;
        	}
        	else{
        		prev.next = curr.next;
        		curr.next = prevM.next;
        		prevM.next = curr;
        		curr = prev.next;
        	}
        }
        return dummy.next;
    }

    /*
    old version
    get the node before m and node after n
    then reverse the nodes between m and n
    time is O(2n-m)
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode lh = newHead;
        ListNode rh = head;
        while(--n > 0) {
            if(--m > 0) {
                lh = lh.next;
            }
            rh = rh.next;
        }
        ListNode prev= rh.next;
        rh.next = null;
        ListNode curr = lh.next;
        while(curr != null && !curr.equals(rh.next))  {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        lh.next = prev;
        return newHead.next;
    }
}