class Solution {
    public void f(int index,int[] candidates, int target,List<Integer> ls,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(index >= candidates.length || target < 0){
            return;
        }

        //Include

        ls.add(candidates[index]);
        target -= candidates[index];
        f(index,candidates,target,ls,ans);

        //Backtrack
        ls.remove(ls.size() - 1);
        target += candidates[index];

        //Exclude
        f(index + 1,candidates,target,ls,ans);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0,candidates,target,new ArrayList<>(),ans);

        return ans;       
    }
}