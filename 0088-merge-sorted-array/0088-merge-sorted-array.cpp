class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int k = m + n - 1;
        int l = m - 1;
        int r = n - 1;

        while(l >= 0 && r >= 0){
            if(nums2[r] > nums1[l]){
                nums1[k--] = nums2[r--];
            }else if(nums1[l] > nums2[r]){
                nums1[k--] = nums1[l--];
            }else{
                nums1[k--] = nums1[l--];
            }
        }

        while(l >= 0){
            nums1[k--] = nums1[l--];
        }

        while(r >= 0){
            nums1[k--] = nums2[r--];
        }
    }
};