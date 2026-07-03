class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        int total_sum = 0;

        for(int val:arr){
            total_sum += val;
        }

        if(total_sum % 3 != 0)return false;

        int count = 0;
        int cur_sum = 0;
        int target = total_sum / 3;


        for(int val:arr){
            cur_sum += val;
            if(cur_sum == target){
                count += 1;
                cur_sum = 0;
            }
        }
        

        return count >= 3;
    }
};