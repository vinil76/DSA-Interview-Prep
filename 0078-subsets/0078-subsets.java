class Solution {
    public void f(int index,int[] nums,List<Integer> temp,List<List<Integer>> ans){
        if(index >= nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //Include 
         temp.add(nums[index]);
        f(index + 1,nums,temp,ans);

        //Backtrack
        temp.remove(temp.size() - 1);

        //Exclude
        f(index + 1,nums,temp,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0,nums,new ArrayList<>(),ans);

        return ans;       
    }
}