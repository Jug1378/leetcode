public class Solution {
	/*
	Find maximum positive difference S defined as:
	S = a[i] - a[j] where i>j and S > 0
	 */
	public int MaxDiff(int[] A) {
		int min = A[0];
		int maxdiff = 0;
		for(int i=1; i<A.length; i++) {
			maxdiff = Math.max(maxdiff, A[i] - min);
			min = Math.min(min, A[i]);
		}
		return maxdiff; 
	}
}