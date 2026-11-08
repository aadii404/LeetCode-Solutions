// // Method 1 :- Brute Force 
// // Time Complexity: O(m * n * (m+n))
// // Space Complexity: O(1)

// class Solution {
//     public int countServers(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int ans = 0;

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 boolean isCommunicate = false;
//                 if(grid[i][j] == 1){
//                     isCommunicate = solve(i, j, grid);
//                 }

//                 if(isCommunicate) ans++;
//             }
//         }

//         return ans;
//     }

//     boolean solve(int row, int col, int[][] grid){

//         // Checking the entire current row for any server
//         for(int i = 0; i < grid[0].length; i++){
//             if(i == col) continue;
//             if(grid[row][i] == 1) return true;
//         }

//         // Checking the entire current column for any server
//         for(int i = 0; i < grid.length; i++){
//             if(i == row) continue;
//             if(grid[i][col] == 1) return true;
//         }

//         return false;
//     }
// }



// Method 2 :- optimized solution 
// Time Complexity: O(m * n)
// Space Complexity: O(m + n)

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)){
                    ans++;
                }
            }
        }

        return ans;
    }
}