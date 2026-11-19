public class _200_no_of_islands {
    public int numIslands(char[][] grid) {

        int count = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {

                    count++;

                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {

        // Boundary check
        if (i < 0 || j < 0 ||
                i >= grid.length ||
                j >= grid[0].length ||
                grid[i][j] == '0') {

            return;
        }

        // Mark visited
        grid[i][j] = '0';

        // Visit four directions
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }
}
