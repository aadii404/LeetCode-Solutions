class Solution {
    int n;
    int[][] dp;
    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int child1 = child1Collect(fruits);
        int child2 = child2Collect(0, n - 1, fruits);
        int child3 = child3Collect(n - 1, 0, fruits);

        return child1 + child2 + child3;
    }

    int child1Collect(int[][] fruits){
        int collected = 0;
        for(int i = 0; i < n; i++){
            collected += fruits[i][i];
        }

        return collected;
    }

    int child2Collect(int i, int j, int[][] fruits){
        if(i >= n || j < 0 || j >= n){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            return 0; // this was already collected by child1
        }

        if(i == j || i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int choise1 = fruits[i][j] + child2Collect(i + 1, j - 1, fruits);
        int choise2 = fruits[i][j] + child2Collect(i + 1, j, fruits);
        int choise3 = fruits[i][j] + child2Collect(i + 1, j + 1, fruits);
        return dp[i][j] = Math.max(choise1, Math.max(choise2, choise3));
    }

    int child3Collect(int i, int j, int[][] fruits){
        if(i >= n || i < 0 || j >= n){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            return 0; // this was already collected by child1
        }

        if(i == j || i < j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int choise1 = fruits[i][j] + child3Collect(i - 1, j + 1, fruits);
        int choise2 = fruits[i][j] + child3Collect(i, j + 1, fruits);
        int choise3 = fruits[i][j] + child3Collect(i + 1, j + 1, fruits);
        return dp[i][j] = Math.max(choise1, Math.max(choise2, choise3));
    }
}