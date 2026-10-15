//Recursion + memoization

class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 == 1) return false;

        int target = sum / 2;
        dp = new int[n + 1][target + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(n, nums, target);
    }

    boolean solve(int n, int[] nums, int sum){
        if(sum == 0) return true;
        if(n == 0) return false;

        if(dp[n][sum] != -1){
            return dp[n][sum] == 1 ? true : false;
        }

        boolean skip = solve(n - 1, nums, sum);

        boolean take = false;
        if(nums[n - 1] <= sum){
            take = solve(n - 1, nums, sum - nums[n - 1]);
        }

        dp[n][sum] = (skip || take) == true ? 1 : 0;

        return skip || take;
    }
}




// bottom up
