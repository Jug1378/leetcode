public class Solution {
    public void reorderList(ListNode head) {
    	/*
    	1)	Break list from the middle (fast & slow pointers)
    	2)	Reverse the second list (Do not forget to close the first list)
    	3)	Merge the two list
    	 */
    	if(head == null || head.next == null || head.next.next == null) return head;
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	fast = slow.next;
    	slow.next = null;
    	fast = reverse(fast);
    	slow = head;
    	while(fast != null) {
    		ListNode temp1 = slow.next;
    		ListNode temp2 = fast.next;
    		slow.next = fast;
    		fast.next = temp1;
    		slow = temp1;
    		fast = temp2;
    	}
    }

    public ListNode reverse(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode prev = null;
    	ListNode curr = head;
    	while(curr != null) {
    		ListNode next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	return prev;
    }
}