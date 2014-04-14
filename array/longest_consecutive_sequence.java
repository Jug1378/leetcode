public class Solution {
	/*
	1) basic methods in HashSet is O(1) time
	2) when an element is checked, it should be removed. It should not be checked again.
	 */
    public int longestConsecutive(int[] num) {
        Set<Integer> s = new HashSet<Integer>();
        int max = 1;
        for(int i : num)
        	s.add(i);
        for(int i : num) {
        	int left = i - 1;
        	int right = i + 1;
        	int count = 1;

        	while(s.contains(left)) {
        		s.remove(left);
        		count++;
        		left--;
        	} 

        	while(s.contains(right)) {
        		s.remove(right);
        		count++;
        		right++;
        	}

        	max = Math.max(max, count);
        }
        return max;
    }
}