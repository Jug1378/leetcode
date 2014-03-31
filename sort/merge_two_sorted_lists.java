public class Solution {
	/*
	recursive method, overhead for recursive function calls in stack, but looks simple
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	if(l1.val < l2.val) {
    		l1.next = mergeTwoLists(l1.next, l2);
    		return l1;
    	}
    	else {
    		l2.next = mergeTwoLists(l2.next, l1);
    		return l2;
    	}
    }

    /*
    iterative method 
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
    			ListNode tmp = l1.next;
    			l1.next = l2;
    			l2 = tmp;
    			l1 = l1.next;
    		}
    	}
    	if(l1.next == null) l1.next = l2;
    	return head;
    } 
}