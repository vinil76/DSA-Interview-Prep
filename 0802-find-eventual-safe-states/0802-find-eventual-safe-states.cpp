class Solution {
public:
    bool dfs(int i, vector<vector<int>>& graph, vector<int>& visited, vector<int>& pathV,vector<int>& safeN) {
        visited[i] = 1;
        pathV[i] = 1;
        safeN[i] = 0;

        for(int val:graph[i]){
            if(!visited[val]){
                if(dfs(val,graph,visited,pathV,safeN)){
                    return true;
                }
            }else if(pathV[val]){
                return true;
            }
        }
        safeN[i] = 1;
        pathV[i] = 0;

        return false;
    }

    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int V = graph.size();
        vector<int> visited(V, 0);
        vector<int> pathV(V, 0);
        vector<int> safeN(V, 0);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, pathV,safeN);
            }
        }

        vector<int>ans;

        for(int i=0;i<V;i++){
            if(safeN[i]){
                ans.push_back(i);
            }
        }

        return ans;
        
    }
};