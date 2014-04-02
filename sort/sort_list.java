public class Solution {
	/*
	Sort a linked list in O(n log n) time using constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		head = sortList(head);
		fast = sortList(fast);
		head = merge(head, fast);
		return head;
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head;
		if(l1.val < l2.val)
			head = l1;
		else {
			head = l2;
			l2 = l1;
			l1 = head;
		}
		while(l1.next != null && l2 != null) {
			if(l1.next.val < l2.val)
				l1 = l1.next;
			else {
				ListNode temp = l1.next;
				l1.next = l2;
				l2 = temp;
				l1 = l1.next;
			}
		}
		if(l2 != null) l1.next = l2;
		return head;
	}
}