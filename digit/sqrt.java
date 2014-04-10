public class Solution {
	/*
	implementation of double sqrt
	 */
	public double sqrt(double n) {
		double i = 0, j = n;
		double mid = (i+j) / 2.0;
		while(Math.abs(mid*mid-n)>0.0001) {
			if(n/mid > mid) i = mid;
			else j = mid;
			mid = (i+j) / 2.0;
		}
		return mid;
		//if we want to get the result of accuracy of two decimal places:
		//return new BigDecimal(mid).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}


	/*
	implementation of int sqrt
	 */
	public int sqrt(int n) {
		if(n <= 1) return n;
		int i=0, j=n;
		while(i <= j) {
			int mid = i+(j-i)/2;
			if(n / mid > mid)
				i = mid + 1;
			else if(n/mid < mid)
				j = mid - 1;
			else
				return mid;
		}
		return j;
	}
}