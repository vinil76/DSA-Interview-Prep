class Solution {
public:
    bool dfs(int i, vector<int> adj[], vector<int>& visited, vector<int>& pathV,
             stack<int>& s) {
        visited[i] = 1;
        pathV[i] = 1;

        for (auto val : adj[i]) {
            if (!visited[val]) {
                if (dfs(val, adj, visited, pathV, s)) {
                    return true;
                }
            } else if (pathV[val]) {
                return true;
            }
        }
        pathV[i] = 0;
        s.push(i);

        return false;
    }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        // int V = numCourses;
        // vector<int> adj[V];

        // for (int i = 0; i < prerequisites.size(); i++) {
        //     int u = prerequisites[i][1];
        //     int v = prerequisites[i][0];

        //     adj[u].push_back(v);
        // }
        // stack<int>s;
        // vector<int> visited(V, 0);
        // vector<int> pathV(V, 0);

        // for (int i = 0; i < V; i++) {
        //     if (!visited[i]) {
        //         if (dfs(i, adj, visited, pathV,s)) {
        //             return {};
        //         }
        //     }
        // }

        // vector<int>ans;
        // while(!s.empty()){
        //     ans.push_back(s.top());
        //     s.pop();
        // }

        // return ans;

        // BFS
        //-----------------------------

        int V = numCourses;
        vector<vector<int>> adj(V);
        vector<int> indegree(V, 0);

        for (int i = 0; i < prerequisites.size(); i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj[u].push_back(v);
            indegree[v]++;
        }

        queue<int> q;
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }

        vector<int> topo;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            topo.push_back(node);

            for (int it : adj[node]) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.push(it);
                }
            }
        }

        if (topo.size() == V){
            return topo;
        }
        
        return {};
    }
};