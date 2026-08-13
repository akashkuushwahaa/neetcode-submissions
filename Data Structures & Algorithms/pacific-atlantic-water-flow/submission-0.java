class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, atl, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, atl, m - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] == 1 && atl[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] heights, int[][] flow, int r, int c) {
        if (flow[r][c] == 1) return;

        flow[r][c] = 1;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nc >= 0 &&
                nr < heights.length &&
                nc < heights[0].length &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(heights, flow, nr, nc);
            }
        }
    }
}