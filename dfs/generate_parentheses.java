public class Solution {
	/*
	first add open paren, when open paren is less than close paren, then add the close paren.
	 */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> arr = new ArrayList<String>();
        String temp = "";
        dfs(arr, temp, n, n);
        return arr;
    }

    public void dfs(ArrayList<String> arr, String temp, int left, int right) {
    	if(left == 0 && right == 0)
    		arr.add(temp);
    	if(left > 0)
    		dfs(arr, temp+"(", left-1, right);
    	if(left < right)
    		dfs(arr, temp+")", left, right-1);
    }
}