class Solution {
    public void f(int start,int[] nums,List<Integer> temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));

        for(int i = start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }

            temp.add(nums[i]);
            f(i + 1,nums,temp,ans);
            temp.remove(temp.size() - 1);
        }


    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        f(0,nums,new ArrayList<>(),ans);

        return ans;        
    }
}