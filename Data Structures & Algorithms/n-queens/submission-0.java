class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        solve(0, board, col, diag1, diag2, n);
        return ans;
    }

    void solve(int row, char[][] board, boolean[] col,
               boolean[] diag1, boolean[] diag2, int n) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) {
                temp.add(new String(r));
            }
            ans.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[row - c + n] || diag2[row + c]) {
                continue;
            }

            board[row][c] = 'Q';
            col[c] = diag1[row - c + n] = diag2[row + c] = true;

            solve(row + 1, board, col, diag1, diag2, n);

            board[row][c] = '.';
            col[c] = diag1[row - c + n] = diag2[row + c] = false;
        }
    }
}