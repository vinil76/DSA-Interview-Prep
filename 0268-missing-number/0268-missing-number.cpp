class Solution {
public:
    int missingNumber(vector<int>& nums) {
        // int n = nums.size();

        // for(int i = 0; i <= nums.size();i++){
        //     bool found = false;

        //     for(int value : nums){
        //         if(i == value){
        //             found = true;
        //             break;
        //         }
        //     }

        //     if(!found){
        //         return i;
        //     }
        // }
        // return -1;

        int ans = 0;
        for (int i = 0; i <= nums.size(); i++) {
            if (i < nums.size()) {
                ans ^= nums[i];
            }
            ans ^= i;
        }
        return ans;
    }
};