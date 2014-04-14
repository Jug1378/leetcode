public class Solution {
	/*
	1) isValid has to check three situations, take care of the 9 cells
	2) dfs has to return boolean considering there is only one accepted result
	3) firstly add the '.' cell to an array list, can not use a queue or a stack as we need 
	   to check the cell repeatedly 
	 */
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<9; i++)
        	for(int j=0; j<9; j++)
        		if(board[i][j] == '.')
        			arr.add(i*9+j);
        int len = arr.size();
        dfs(board, arr, 0, len);
    }

    public boolean dfs(char[][] board, ArrayList<Integer> arr, int cur, int len) {
    	if(cur == len) return true;
    	int index = arr.get(cur);
    	int row = index / 9;
    	int col = index % 9;
    	for(int k=1; k<=9; k++) {
    		if(isValid(k, row, col, board)) {
    			board[row][col] = (char)(k + '0');
    			if(dfs(board,arr,cur+1,len))
    				return true;
    			board[row][col] = '.';
    		}
    	}
    	return false;
    }

    public boolean isValid(int k, int row, int col, char[][] board) {
    	for(int i=0; i<9; i++) {
    		if(board[row][i] - '0' == k || board[i][col] - '0' == k)
    			return false;
    		if(board[row/3 * 3 + i/3][col/3 * 3 + i%3] -'0' == k)
    			return false;
    	}
    	return true;
    }
}