class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

     if(matrix.length == 0) return false;

       int n = matrix.length;
       int m = matrix[0].length;

       int row = 0;
       int col = m-1;

       while(row < n && col >= 0){

            if(matrix[row][col] == target) return true;

            if(target > matrix[row][col]){
                row++;
            }
            else{
                col--;
            }
       }
        
        return false;
    }
}