class Solution {
public:
    bool dfs(int i, vector<int> adj[], vector<int>& visited,
             vector<int>& pathV) {
        visited[i] = 1;
        pathV[i] = 1;

        for (auto val : adj[i]) {
            if (!visited[val]) {
                if (dfs(val, adj, visited, pathV)) {
                    return true;
                }
            } else if (pathV[val]) {
                return true;
            }
        }
        pathV[i] = 0;

        return false;
    }
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // vector<int> adj[numCourses];
        // for (int i = 0; i < prerequisites.size(); i++) {
        //     int u = prerequisites[i][1];
        //     int v = prerequisites[i][0];

        //     adj[u].push_back(v);
        // }

        // int V = numCourses;
        // vector<int> visited(V, 0);
        // vector<int> pathV(V, 0);

        // for (int i = 0; i < V; i++) {
        //     if (!visited[i]) {
        //         if (dfs(i, adj, visited, pathV)) {
        //             return false;
        //         }
        //     }
        // }
        // return true;

        //BFS
        //---------------

        int V = numCourses;
        vector<vector<int>>adj(V);
        vector<int>indegree(V,0);

        for (int i = 0; i < prerequisites.size(); i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj[u].push_back(v);
            indegree[v]++;
        }

        queue<int>q;
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.push(i);
            }
        }

        int cnt = 0;

        while(!q.empty()){
            int node = q.front();
            q.pop();

            cnt += 1;

            for(int it:adj[node]){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.push(it);
                }
            }
        }

        return (cnt == V) ? true : false;
    }
};