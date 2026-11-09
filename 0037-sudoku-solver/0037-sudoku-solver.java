class Solution {
    public void solveSudoku(char[][] board) {

        solver(board);

    }

    public boolean solver(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(c, i, j, board)) {

                            board[i][j] = c;

                            if (solver(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }

                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char c, int row, int col, char[][] board) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == c) {
                return false;
            }
            if (board[i][col] == c) {
                return false;
            }
            //formula for 3X3 board check
            int smallRow = 3 * (row / 3) + i / 3;
            int smallCol = 3 * (col / 3) + i % 3;

            if (board[smallRow][smallCol] == c) {
                return false;
            }
        }

        return true;
    }
}