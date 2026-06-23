class Solution {
    public void f(int start,int[] candidates, int target,List<Integer> ls,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i = start;i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }

            if(candidates[i] > target){
                break;
            }

            ls.add(candidates[i]);
            f(i + 1,candidates,target - candidates[i],ls,ans);
            ls.remove(ls.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        f(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
}