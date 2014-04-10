public class Solution {
	/*
	1) dfs has too many overhead for the time and space, we use bfs.
	2) use an array of int[][] to indicate the direction
	3) take care of the boundary check
	
	X X X X
	X O O X
	X X O X
	X O X X

	After function,

	X X X X
	X X X X
	X X X X
	X O X X
	
	 */
    public void solve(char[][] board) {
    	if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
        	bfs(board, i, 0);
        	bfs(board, i, n-1);
        }

        for(int i=1; i<n-1; i++) {
        	bfs(board, 0, i);
        	bfs(board, m-1, i);
        }

        for(int i=0; i<m; i++)
        	for(int j=0; j<n; j++) {
        		if(board[i][j] == 'D')
        			board[i][j] = 'O';
        		else if(board[i][j] == 'O')
        			board[i][j] = 'X';
        	}
    }

    public void bfs(char[][] board, int i, int j) {
    	if(board[i][j] == 'X') return;
    	int m = board.length;
    	int n = board[0].length;
    	int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    	Queue<Integer> q = new LinkedList<Integer>();
    	board[i][j] = 'D';
    	q.add(i*n+j);
    	while(!q.isEmpty()) {
    		int top = q.poll();
    		i = top / n;
    		j = top % n;
    		for(int[] dd : d) {
    			int a = i + dd[0];
    			int b = j + dd[1];
    			if(a >= 0 && a < m && b >=0 && b < n && board[a][b] == 'O') {
    				board[a][b] ='D';
    				q.add(a*n+b);
    			}
    		}
    	}
    }
}