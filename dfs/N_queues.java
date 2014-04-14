public class Solution {
	/*
	use a 1D-array rather than 2D-array to record the location
	 */
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> arr = new ArrayList<String[]>();
        int[] loc = new int[n];
        dfs(arr, loc, n, 0);
        return arr;
    }

    public void dfs(ArrayList<String[]> arr, int[] loc, int n, int cur) {
    	if(cur == n){
    		printboard(arr, loc, n);
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		loc[cur] = i;
    		if(isValid(loc, cur))
    			dfs(arr, loc, n, cur+1);
    	}
    }

    public boolean isValid(int[] loc, int cur) {
    	for(int i=0; i<cur; i++) {
    		if(loc[i] == loc[cur] || Math.abs(loc[cur] - loc[i]) == cur - i)
    			return false;
    	}
    	return true;
    }

    public void printboard(ArrayList<String[]> arr, int[] loc, int n) {
    	String[] s = new String[n];
    	for(int i=0; i<n; i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j =0; j<n; j++) {
    			if(loc[i] == j) sb.append("Q");
    			else	sb.append(".");
    		}
    		s[i] = sb.toString();
    	}
    	arr.add(s);
    }
}