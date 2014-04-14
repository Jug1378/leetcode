public class Solution {
	/*
	make the list into a loop and then cut at the right node
	 */
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n == 0) return head;
        int len = 1;
        ListNode p = head;
        while(p.next != null) {
        	p = p.next;
        	len++;
        }
        p.next = head;
        n = n % len;
        for(int i=0; i<len-n; i++)
        	p = p.next;
        head = p.next;
        p.next = null;
        return head;
    }
}