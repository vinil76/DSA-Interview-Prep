class Solution {
    public void bfs(int mm,int nn,char[][] grid,List<List<Boolean>> visited){
        visited.get(mm).set(nn,true);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{mm,nn});

        int m = grid.length;
        int n = grid[0].length;

        int[] drow = {1,-1,0,0};
        int[] dcol = {0,0,1,-1};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int i=0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];


                if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && grid[nrow][ncol] == '1' && !visited.get(nrow).get(ncol)){
                    visited.get(nrow).set(ncol,true);
                    q.add(new int[]{nrow,ncol});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Boolean>> visited = new ArrayList<>();

        for(int i = 0;i<m;i++){
            List<Boolean> row = new ArrayList<>();
            for(int j = 0;j<n;j++){
                row.add(false);
            }

            visited.add(row);
        }

        int ans = 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!visited.get(i).get(j) && grid[i][j] == '1'){
                    ans++;
                    bfs(i,j,grid,visited);
                }
            }
        }

        return ans;
    }
}