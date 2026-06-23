class Solution {
    Integer[] dp;

    public int f(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if(dp[target] != null){
            return dp[target];
        }

        int ways = 0;

        for (int num : nums) {
            ways += f(nums, target - num);
        }

        return dp[target] = ways;

    }

    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target + 1];
        return f(nums, target);
    }
}