public class Solution {
	/*
	iterative
	 */
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode pHead = new ListNode(-1);
    	pHead.next = head;
    	ListNode p1 = pHead, p2 = head;
    	while(p2 != null && p2.next != null) {
    		ListNode temp = p2.next.next;
    		p2.next.next = p1.next;
    		p1.next = p2.next;
    		p2.next = temp;
    		p1 = p2;
    		p2 = p1.next;
    	}
    	return pHead.next;
    }

    /*
    recursive
     */
    public ListNode swapPairs2(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode nextPairs = head.next.next;
    	ListNode newHead = head.next;
    	head.next.next = head;
    	head.next = swapPairs2(nextPairs);
    	return newHead;
    }
}