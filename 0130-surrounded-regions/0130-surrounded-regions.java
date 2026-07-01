class Solution {
    public void dfs(int row, int col, char[][] board, int[][] visited) {
        visited[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};

        for(int i = 0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];


            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && board[nrow][ncol] == 'O' && visited[nrow][ncol] == 0){
                dfs(nrow,ncol,board,visited);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

         for(int i = 0;i<m;i++){
            if(board[0][i] == 'O' && visited[0][i] == 0){
                dfs(0,i,board,visited);
            }

            if(board[n-1][i] == 'O' && visited[n-1][i] == 0){
                dfs(n-1,i,board,visited);
            }
        }

        for(int i = 0;i<n;i++){
            if(board[i][0] == 'O' && visited[i][0] == 0){
                dfs(i,0,board,visited);
            }

            if(board[i][m-1] == 'O' && visited[i][m-1] == 0){
                dfs(i,m-1,board,visited);
            }
        }


        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}