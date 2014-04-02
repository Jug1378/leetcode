public class Solution {
	/*
	insertion sort:
	best case O(N) in ascending order
	worst case O(N^2) in descending order
	For partially-sorted arrays, runs in linear time.
	 */
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(head.val);
        ListNode cursor = head.next;
        while(cursor != null) {
        	ListNode prev = newHead;
        	ListNode next = cursor.next;
        	if(cursor.val < newHead.val) {
        		ListNode oldHead = newHead;
        		newHead = cursor;
        		cursor.next = oldHead;
        	}
        	else {
        		while(prev.next != null && cursor.val >= prev.next.val) prev = prev.next;
        		if(prev.next == null) {
        			prev.next = cursor;
        			cursor.next = null;
        		}
        		else {
        			ListNode temp = prev.next;
        			prev.next = cursor;
        			cursor.next = temp;
        		}
        	}
        	cursor = next;
        }
        return newHead;
    }
}