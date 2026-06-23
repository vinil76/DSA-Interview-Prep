class Solution {
public:
    void f(int index,vector<int>& candidates, int target,vector<int> &temp,vector<vector<int>> &ans){
        if(target == 0){
            ans.push_back(temp);
            return;
        }

        if(index >= candidates.size() || target < 0){
            return;
        }


        //Include
        temp.push_back(candidates[index]);
        target -= candidates[index];
        f(index,candidates,target,temp,ans);

        //Backtrack
        temp.pop_back();
        target += candidates[index];

        //Exclude
        f(index + 1,candidates,target,temp,ans);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> temp;

        f(0,candidates,target,temp,ans);

        return ans;
    }
};