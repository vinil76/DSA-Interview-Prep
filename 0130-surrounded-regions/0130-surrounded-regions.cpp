class Solution {
public:
    void dfs(int row, int col, vector<vector<char>>& mat,vector<vector<int>>& visited) {

        visited[row][col] = 1;

        int n = mat.size();
        int m = mat[0].size();

        int drow[] = {0, 0, 1, -1};
        int dcol[] = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && ncol >= 0 && ncol < m && nrow < n &&
                mat[nrow][ncol] == 'O' && !visited[nrow][ncol]) {
                dfs(nrow, ncol, mat, visited);
            }
        }
    }
    void solve(vector<vector<char>>& mat) {
        int n = mat.size();
        int m = mat[0].size();

        vector<vector<int>> visited(n, vector<int>(m, 0));
        //vector<vector<char>> sur = mat;

        for (int i = 0; i < m; i++) {
            if (mat[0][i] == 'O' && !visited[0][i]) {
                dfs(0, i, mat, visited);
            }

            if (mat[n - 1][i] == 'O' && !visited[n - 1][i]) {
                dfs(n - 1, i, mat, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, mat, visited);
            }

            if (mat[i][m - 1] == 'O' && !visited[i][m - 1]) {
                dfs(i, m - 1, mat, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && !visited[i][j]) {
                    //sur[i][j] = 'X';
                    mat[i][j] = 'X';
                }
            }
        }

    }
};