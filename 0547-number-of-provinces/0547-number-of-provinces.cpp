class Solution {
public:
    void dfs(int start, vector<vector<int>> &adj,vector<int> &visited){
        visited[start] = 1;

        for(int val:adj[start]){
            if(!visited[val]){
                dfs(val,adj,visited);
            }
        }
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<vector<int>> adj(n);

        int row = isConnected.size();
        int col = isConnected[0].size();

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }

        vector<int>visited(n,0);


        int ans = 0;
        for(int i = 0;i<isConnected[0].size();i++){
            if(!visited[i]){
                ans += 1;
                dfs(i,adj,visited);
            }
        }

        return ans;
    }
};