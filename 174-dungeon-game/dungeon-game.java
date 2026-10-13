// approach 1 get tle

// class Solution {
//     int m, n;
//     int[][] dp;
//     public int calculateMinimumHP(int[][] dungeon) {
//         m = dungeon.length;
//         n = dungeon[0].length;
//         int left = 1, right = 10_000_000;
//         // 200 * 200 * 1000 maxHealth

//         int minHealth = 10_000_000;
//         while(left <= right){
//             int mid = left + (right - left) / 2;

//             if(canSurvive(0,0, mid, dungeon)){
//                 minHealth = mid;
//                 right = mid - 1;
//             }else{
//                 left = mid + 1;
//             }
//         }

//         return minHealth;
//     }

//     boolean canSurvive(int i, int j, int mid, int[][] dungeon){
//         if(i >= m || j >= n) {
//             return false;
//         }

//         mid += dungeon[i][j];

//         if(mid <= 0){
//             return false;
//         }

//         if(i == m - 1 && j == n - 1){
//             return true;
//         }

//         return canSurvive(i, j + 1, mid, dungeon) || canSurvive(i + 1, j, mid, dungeon);
//     }
// }



// approach 2 recursion + memo

class Solution {
    int m, n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[201][201];
        // 200 * 200 * 1000 maxHealth

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0, dungeon);
    }

    int solve(int i, int j, int[][] dungeon){
        if(i >= m || j >= n) {
            return 1_000_000_000;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == m - 1 && j == n - 1){
            if(dungeon[i][j] > 0){
                return 1;
            }
            return Math.abs(dungeon[i][j]) + 1;
        }

        int right = solve(i, j + 1, dungeon);
        int down = solve(i + 1, j, dungeon);

        int result = Math.min(right, down) - dungeon[i][j];

        return dp[i][j] = (result > 0) ? result : 1;
    }
}