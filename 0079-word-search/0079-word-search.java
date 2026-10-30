class Solution {
    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0) && dfs(0, board, i, j, word)) {

                    return true;
                }
            }
        }

        return false;

    }

    public boolean dfs(int pos, char[][] board, int i, int j, String word) {

        if (pos == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';

        boolean result = (dfs(pos + 1, board, i + 1, j, word) ||
                dfs(pos + 1, board, i - 1, j, word) ||
                dfs(pos + 1, board, i, j + 1, word) ||
                dfs(pos + 1, board, i, j - 1, word));

        board[i][j] = temp;
        return result;
    }
}