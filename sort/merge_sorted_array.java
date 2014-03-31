/*
Assume A has enough space, scan from the end, time O(m+n)
 */
public class Solution {
	public void merge(int[] A, int m, int[] B, int n) {
		int k = m + n - 1;
		m = m - 1;
		n = n - 1;
		while(m >= 0 && n >= 0) {
			if(A[m] > B[n])	A[k--] = A[m--];
			else A[k--] = B[n--];
		}
		while(m >= 0) A[k--] = A[m--];
		while(n >= 0) A[k--] = B[n--];
	}
}