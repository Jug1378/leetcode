public class Solution {
	/*
	procedure:
	1)	reverse order is the most large, so we need to find the one which is not in
		reverse order, when num[i+1] is more than num[i]
	2)	then we need to find the one in num[i+1] to num[len-1] which is closet to this
		number and bigger than it
	3)	next swap these two number and reverse the array after the target number
	 */
    public void nextPermutation(int[] num) {
        int len = num.length;
        int i,j;
        if(len == 1) return;
        for(i=len-2; i>=0; i--) {
        	if(num[i+1] > num[i]) {
        		for(j=len-1; j>=i; j--)
        			if(num[j] > num[i])
        				break;
        		int temp = num[j];
        		num[j] = num[i];
        		num[i] = temp;
        		reverse(num, i+1, len-1);
        		return;
        	}
        }
        reverse(num, 0, len-1);
    }

    public void reverse(int[] num, int start, int end) {
    	while(start < end) {
    		int temp = num[start];
    		num[start] = num[end];
    		num[end] = temp;
    		start++;
    		end--;
    	}
    }
}
