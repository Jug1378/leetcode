public class Solution {
	/*
	use PriorityQueue, elements in the queue are order by natural ordering or by 
	a Comparator.
	compare object:
	1) implement Comparable, override the compareTo method
	2) create new Comparator, override the compare method, which can be used in
	   Collections.sort() or Arrays.sort()
	 */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), 
        	new Comparator<ListNode>() {
        		public int compare(ListNode a, ListNode b) {
        			if(a.val < b.val) return -1;
        			else if(a.val > b.val) return 1;
        			else return 0;
        		}
        	});
        for(ListNode list: lists) {
        	if(list != null)
        		pq.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode prev = head;
        while(!pq.isEmpty()) {
        	ListNode temp = pq.poll();
        	prev.next = temp;
        	if(temp.next != null)
        		pq.add(temp.next);
        	prev = prev.next;
        }
        return head.next;
    }
}