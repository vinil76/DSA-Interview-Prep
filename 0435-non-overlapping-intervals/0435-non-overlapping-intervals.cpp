class Solution {
public:
    bool static compare(const pair<int,int>&a,const pair<int,int>&b){
      return a.second < b.second;
      }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
         vector<pair<int,int>>nums;
        for(vector<int> val:intervals){
          nums.push_back({val[0],val[1]});
        }

        sort(nums.begin(),nums.end(),compare);

       int count = 1;
        int last_end = nums[0].second;

        for(int i = 1; i < nums.size(); i++){
            if(nums[i].first >= last_end){
                count++;
                last_end = nums[i].second;
            }
        }
        return intervals.size()-count;
        
    }
};