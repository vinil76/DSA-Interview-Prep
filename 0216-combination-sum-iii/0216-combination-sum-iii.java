class Solution {
    public void f(int start,int k, int n,int sum,List<Integer> temp, List<List<Integer>> ans){
        if(k == 0){
            if(sum == n){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (start > 9) {
            return;
        }

        sum += start;
        temp.add(start);
        f(start + 1,k - 1,n,sum,temp,ans);

        sum -= start;
        temp.remove(temp.size() - 1);
        f(start + 1,k,n,sum,temp,ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        f(1,k,n,0,new ArrayList<>(),ans);

        return ans;        
    }
}