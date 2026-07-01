class Solution {
    public void dfs(int row, int col, int[][] grid, int[][] visited) {
        visited[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};

        for(int i = 0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];


            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0){
                dfs(nrow,ncol,grid,visited);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

         for(int i = 0;i<m;i++){
            if(grid[0][i] == 1 && visited[0][i] == 0){
                dfs(0,i,grid,visited);
            }

            if(grid[n-1][i] == 1 && visited[n-1][i] == 0){
                dfs(n-1,i,grid,visited);
            }
        }

         for(int i = 0;i<n;i++){
            if(grid[i][0] == 1 && visited[i][0] == 0){
                dfs(i,0,grid,visited);
            }

            if(grid[i][m-1] == 1 && visited[i][m-1] == 0){
                dfs(i,m-1,grid,visited);
            }
        }

        int ans = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    ans++;
                }
            }
        }

        return ans;

    }
}