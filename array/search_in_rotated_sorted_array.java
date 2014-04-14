public class Solution {
	/*
	no duplicate
	 */
    public int search(int[] A, int target) {
    	int lh = 0;
    	int rh = A.length-1;
    	while(lh <= rh) {
    		//avoid overflow
    		int mid = lh + (rh - lh)/2;
    		if(target == A[mid]) return mid;
    		// the bottom half is sorted
    		if(A[mid] > A[lh]) {
    			if(target >= A[lh] && target < A[mid])
    				rh = mid-1;
    			else
    				lh = mid+1;
    		}
    		// the upper half is sorted
    		else {
    			if(target > A[mid] && target <= A[rh])
    				lh = mid+1;
    			else
    				rh = mid-1;
    		}
    	}
    	return -1;
    }

    /*
    has duplicates, just check the next element if left == mid
     */
    public int search2(int[] A, int target) {
    	int lh = 0;
    	int rh = A.length-1;
    	while(lh <= rh) {
    		//avoid overflow
    		int mid = lh + (rh - lh)/2;
    		if(target == A[mid]) return mid;
    		// the bottom half is sorted
    		if(A[mid] > A[lh]) {
    			if(target >= A[lh] && target < A[mid])
    				rh = mid-1;
    			else
    				lh = mid+1;
    		}
    		// the upper half is sorted
    		else if(A[mid] < A[lh]){
    			if(target > A[mid] && target <= A[rh])
    				lh = mid+1;
    			else
    				rh = mid-1;
    		}
    		else
    			lh++;
    	}
    	return -1;
    }

    /*
    find the rotation pivot
     */
    public int findSortArrayRotation(int[] A) {
    	int lh = 0;
    	int rh = A.length-1;
    	while(A[lh] > A[rh]) {
    		int mid = lh + (rh - lh)/2;
    		if(A[mid] > A[lh])
    			rh = mid-1;
    		else
    			lh = mid+1;
    	}
    	return lh;
    }
}