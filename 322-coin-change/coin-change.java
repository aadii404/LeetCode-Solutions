class Solution {
    int dp[][];

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(n, coins, amount);
        return ans >= Integer.MAX_VALUE - 1 ? -1 : ans;
    }

    int solve(int n, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (n == 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (dp[n][amount] != -1) {
            return dp[n][amount];
        }

        int skip = solve(n - 1, coins, amount);

        int take = Integer.MAX_VALUE - 1;

        if (coins[n - 1] <= amount) {
            take = 1 + solve(n, coins, amount - coins[n - 1]);
        }

        return dp[n][amount] = Math.min(take, skip);
    }
}