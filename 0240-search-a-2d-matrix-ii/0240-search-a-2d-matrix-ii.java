class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int row = n-1;
        int col = 0;

        while(col < m && row >= 0){

            if(matrix[row][col] == target) return true;

            else if(matrix[row][col] < target) col++;

            else row--;
        }
        
        return false;
    }
}