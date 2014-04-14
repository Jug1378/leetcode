public class Solution {
	/*
	scan the list to get the length of list and the last node
	then make a second scan:
	if the node is less than the given number, just get next node
	else make a new node after the last node until reach the end of original list
	 */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        int len = 0;
        ListNode p = newHead;
        while(p.next != null) {
        	p = p.next;
        	len++;
        }
        ListNode end = p;
        p = newHead;
        while(len > 0) {
        	if(p.next.val < x)
        		p = p.next;
        	else {
        		ListNode n = new ListNode(p.next.val);
        		end.next = n;
        		end = n;
        		p.next = p.next.next;
        	}
        	len--;
        }
        return newHead.next;
    }
}