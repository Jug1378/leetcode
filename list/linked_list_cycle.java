public class Solution {
	/*
	check if the linked list contains a cycle
	 */
    public boolean hasCycle(ListNode head) {
    	if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
        	if(fast == slow || fast.next == slow) return true;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return false;
    }

    /*
    return the node where the cycle begins, if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
        	slow = slow.next;              // can not put the two lines code under if(fast == slow) loop
        	fast = fast.next.next;		   // or at first slow == fast would get into the final check condition
        	if(fast == slow) {
        		slow = head;
        		while(slow != fast) {
        			slow = slow.next;
        			fast = fast.next;
        		}	
        		return slow;
        	}
        }
        return null;
    }

}