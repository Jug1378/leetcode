public class Solution {
	//longest increasing subsequence
	
	/*
	DP algorithm
	time: O(N^2)
	space: O(N)
	 */
	public int LIS(int[] A) {
		int len = A.length;
		int[] N = new int[len];
		int max = 1;
		for(int i=0; i<len; i++) {
			N[i] = Integer.MAX_VALUE;
		}

		for(int i=0; i<len; i++) {
			N[i] = 1;
			for(int j=0; j<i; j++) {
				if(A[j] <= A[i])
					N[i] = Math.max(N[j]+1, N[i]);
			}
			if(N[i] > max) max = N[i];
		}

		return max;
	}

	/*
	time: O(NlogN)
	space: O(maxLength)
	 */
	public int LIS2(int[] A) {
		int len = A.length;
		int[] M = new int[len];
		int len = 1;
		int left, right, mid;
		M[0] = A[0];
		for(int i=1; i<len; i++) {
			left = 0;
			right = len-1;
			while(left <= right) {
				mid = left + (right - left) / 2;
				if(M[mid] < A[i]) left = mid + 1;
				else right = mid - 1;
			}
			M[left] = A[i];
			if(left > len) len++;
		}
		return len;
	}


}