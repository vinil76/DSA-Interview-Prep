class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char,int>m;

        for(char val:s){
            m[val] += 1;
        }

        priority_queue<pair<int,int>>pq;
        for(auto [c,f] : m){
            pq.push({f,c});
        }

        string ans = "";
        while(!pq.empty()){
            auto [f,c] = pq.top();
            pq.pop();

            ans.append(f,c);
        }


        return ans;
    }
};