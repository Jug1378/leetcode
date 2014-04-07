public class Solution {
	/*
	1)	first determine the length of String, which is less than 4 or more than 13, return false
	2)	isValid() function, we need take care of the situations with 0 start, like "000", "012"
		is not valid, where only "0" is valid 
	3)	in order to handle the final valid situation more convieniently, we just process the last
		valid string into StringBuffer and if not valid, just return 
	 */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> arr = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        if(s.length() < 4 || s.length() > 12) return arr;
        dfs(arr, s, sb, 0);
        return arr;
    }

    public void dfs(ArrayList<String> arr, String s, StringBuffer sb, int k) {
    	if(k == 3) {
    		if(isValid(s)) {
    			arr.add(sb.append(s).toString());
    			sb.delete(sb.length()-s.length(), sb.length());
    		}
    		return;
    	}
    	for(int i = 1; i<=3 && i<s.length(); i++) {
    		String sub = s.substring(0, i);
    		if(isValid(sub)) {
    			sb.append(sub);
    			sb.append(".");
    			dfs(arr, s.substring(i), sb, k+1);
    			sb.delete(sb.length()-i-1, sb.length());
    		}
    	}
    }

    public boolean isValid(String s) {
    	if(s.charAt(0)=='0') return s.equals("0");
    	int i = Integer.parseInt(s);
    	return (i >= 0) && (i <= 255);
    }
}