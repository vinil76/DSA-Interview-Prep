class Solution {
public:
    bool bipartie(int node,vector<vector<int>>& adj,vector<int>& visited,vector<int>& color){
        visited[node] = 1;
        color[node] = 1;

        queue<int>q;
        q.push(node);

        while(!q.empty()){
            int cur = q.front();
            q.pop();

            for(int val:adj[cur]){
                if(!visited[val]){
                    visited[val] = 1;
                    color[val] = 1 - color[cur];
                    q.push(val);
                }else if(color[cur] == color[val]){
                    return false;
                }
            }
        }

        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        // vector<vector<int>>adj(V);
        // for(auto edge:edges){
        //     int u = edge[0];
        //     int v = edge[1];

        //     adj[u].push_back(v);
        //     adj[v].push_back(u);
        // }

        int V = graph.size();

        vector<int>visited(V,0);
        vector<int>color(V,0);

        for(int i = 0;i<V;i++){
            if(!visited[i]){
                if(!bipartie(i,graph,visited,color)){
                    return false;
                }
            }
        }

        return true; 
    }
};