class Solution {
    public void dfs(int node,List<List<Integer>> adj,List<Integer> visited){
        visited.set(node,1);

        for(int val:adj.get(node)){
            if(visited.get(val) != 1){
                dfs(val,adj,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                } 
            }
        }

        List<Integer> visited = new ArrayList<>();

        for(int i = 0;i<n;i++){
            visited.add(0);
        }

        int ans = 0;

        for(int i = 0;i<n;i++){
            if(visited.get(i) != 1){
                ans += 1;
                dfs(i,adj,visited);
            }
        }

        return ans;
    }
}