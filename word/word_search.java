public class Solution {
	/*
	dfs
	 */
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        char c = word.charAt(0);
        for(int i=0; i<m; i++)
        	for(int j=0; j<n; j++) {
        		if(board[i][j] == c) {
        			board[i][j] = ' ';
        			if(dfs(board, word.substring(1), i, j)) return true;
        			board[i][j] = c; 
        		}
        	}
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j) {
    	if(word.length() == 0) return true;
    	int m = board.length;
        int n = board[0].length;
    	int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    	char c = word.charAt(0);
    	for(int[] d:dir) {
    		int a = i + d[0];
    		int b = j + d[1];
    		if(a >= 0 && a < m && b >= 0 && b < n && board[a][b] == c) {
    			board[a][b] = ' ';
    			if(dfs(board, word.substring(1), a, b)) return true;
        		board[a][b] = c; 
    		}
    	}
    	return false;
    }
}