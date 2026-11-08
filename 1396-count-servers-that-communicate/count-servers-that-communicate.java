class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean isCommunicate = false;
                if(grid[i][j] == 1){
                    isCommunicate = solve(i, j, grid);
                }

                if(isCommunicate) ans++;
            }
        }

        return ans;
    }

    boolean solve(int row, int col, int[][] grid){

        for(int i = 0; i < grid[0].length; i++){
            if(i == col) continue;
            if(grid[row][i] == 1) return true;
        }

        for(int i = 0; i < grid.length; i++){
            if(i == row) continue;
            if(grid[i][col] == 1) return true;
        }

        return false;
    }
}