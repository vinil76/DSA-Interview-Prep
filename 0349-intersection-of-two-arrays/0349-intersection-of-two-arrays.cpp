class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        // set<int> s;
        // vector<int> ans;

        // for(int i = 0;i<nums1.size();i++){
        //     for(int j = 0;j<nums2.size();j++){
        //         if(nums1[i] == nums2[j]){
        //             if(s.find(nums1[i]) == s.end()){
        //                 s.insert(nums1[i]);
        //                 ans.push_back(nums1[i]);
        //             }
        //         }
        //     }
        // }

        // return ans;


        unordered_set<int> s(nums1.begin(),nums1.end());
        vector<int> ans;

        for(int val : nums2){
            if(s.find(val) != s.end()){
                ans.push_back(val);
                s.erase(val);
            }
        }

        return ans;
    }
};