class Solution {
	public int numOf1s(int n) {
		int flag = 1;
		int len = 0;
		int max = 0;
		while(flag != 0) {
			if((n & flag) != 0) {
				len = 0;
				while(flag != 0 && (n & flag) != 0) {
					flag = flag << 1;
					len++;
				}
				if(len > max) max = len;
			}
			flag = flag << 1;
		}
		return max;
	}
}