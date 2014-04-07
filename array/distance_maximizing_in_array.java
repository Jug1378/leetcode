public class Solution {
	/*
	given an array A, find maximum j-i where A[j] > A[i]

	1)	Brute Force O(N^2)
	2)	two auxiliary arrays LMin[] and RMax[]
		because if there is a greater element on right side of arr[j], 
			we won't consider j as right index
		same way, if there is a smaller element on left side of arr[i],
			we won't consider i as left index
	
	 */
	public int MaxDistance(int[] A) {
		int len = A.length;
		int[] LMin = new int[len];
		int[] RMax = new int[len];
		LMin[0] = A[0];
		RMax[len-1] = A[len-1];
		
		for(int i=1; i<len; i++)
			LMin[i] = Math.min(LMin[i-1], A[i]);
		for(int i=len-2; i>=0; i--)
			RMax[i] = Math.max(RMax[i+1], A[i]);

		int i=0, j=0, max=0;
		while(i<len && j<len) {
			if(LMin[i] < RMax[j]) {
				max = Math.max(max, j-i);
				j++;
			}
			else
				i++;
		}
		return max;
	} 
}