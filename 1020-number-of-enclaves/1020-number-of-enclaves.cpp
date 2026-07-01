class Solution {
public:
    void bfs(int i,int j,vector<vector<int>> &grid,vector<vector<int>>&visited){
        visited[i][j] = 1;

        queue<pair<int,int>>q;
        q.push({i,j});

        int n = grid.size();
        int m = grid[0].size();

        int drow[] = {-1, 1, 0, 0};
        int dcol[] = {0, 0, -1, 1};

        while(!q.empty()){
            int row = q.front().first;
            int col = q.front().second;

            q.pop();

            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                    visited[nrow][ncol] = 1;
                    q.push({nrow,ncol});
                }
            }
        }
    }
    int numEnclaves(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();

        vector<vector<int>>visited(row,vector<int>(col,0));

        for(int i=0;i<col;i++){
            if(grid[0][i] == 1 && !visited[0][i]){
                bfs(0,i,grid,visited);
            }

            if(grid[row-1][i] == 1 && !visited[row - 1][i]){
                bfs(row - 1,i,grid,visited);
            }
        }

        for(int i = 0;i<row;i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                bfs(i,0,grid,visited);
            }

            if(grid[i][col - 1] == 1 && !visited[i][col - 1]){
                bfs(i,col - 1,grid,visited);
            }
        }

        int ans = 0;

        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                   ans += 1;
                }
            }
        }
        return ans;
        
    }
};