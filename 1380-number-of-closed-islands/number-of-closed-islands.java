class Solution {
    int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    if(dfs(i, j, grid)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    boolean dfs(int i, int j, int[][] grid){        
        // out of bound
        if(i >= m || i < 0 || j >= n || j < 0){
            return false;
        }
        
        if(grid[i][j] == 1){ // closed with water
            return true;
        }

        grid[i][j] = 1; // mark visited

        boolean left_closed = dfs(i , j - 1, grid);
        boolean right_closed = dfs(i , j + 1, grid);
        boolean up_closed = dfs(i - 1, j, grid);
        boolean down_closed = dfs(i + 1, j, grid);

        return left_closed && right_closed && up_closed && down_closed;
    }
}