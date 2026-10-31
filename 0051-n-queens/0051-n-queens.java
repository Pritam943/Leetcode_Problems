class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the empty board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Track attacked lines to achieve O(1) lookups
        Set<Integer> rows = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); // (col - row) constant for major diagonals
        Set<Integer> diag2 = new HashSet<>(); // (row + col) constant for minor diagonals
        
        backtrack(0, n, board, res, rows, diag1, diag2);
        return res;
    }
    
    private void backtrack(int col, int n, char[][] board, List<List<String>> res, 
                           Set<Integer> rows, Set<Integer> diag1, Set<Integer> diag2) {
        // Base Case: All queens successfully placed
        if (col == n) {
            res.add(construct(board));
            return;
        }
        
        // Try placing a queen in each row of the current row
        for (int row = 0; row < n; row++) {
            int d1 = (n-1) + (col - row);
            int d2 = row + col;
            
            // Check if the cell is under attack
            if (rows.contains(row) || diag1.contains(d1) || diag2.contains(d2)) {
                continue; 
            }
            
            // 1. Choose
            board[row][col] = 'Q';
            rows.add(row);
            diag1.add(d1);
            diag2.add(d2);
            
            // 2. Explore next row
            backtrack(col + 1, n, board, res, rows, diag1, diag2);
            
            // 3. Un-choose (Backtrack)
            board[row][col] = '.';
            rows.remove(row);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }
    
    // Helper function to convert the char array into the required list format
    private List<String> construct(char[][] board) {
        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            internal.add(new String(board[i]));
        }
        return internal;
    }
}