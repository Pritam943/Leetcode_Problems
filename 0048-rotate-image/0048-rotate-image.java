class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

//Transpose the matrix arr[i][j] swap with arr[j][i] except diagonals

        for(int i=0; i<n; i++){

            for(int j=i+1; j<m; j++){

                  int temp = matrix[i][j];
                  matrix[i][j] = matrix[j][i];
                  matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++){

             reverseEveryRow(matrix, i, m);
        }
        
    }

    public void reverseEveryRow(int[][] matrix, int row, int m){

          int low = 0;
          int high = m-1;

          while(low < high){

               int temp = matrix[row][low];
               matrix[row][low] = matrix[row][high];
               matrix[row][high] = temp;
               low++;
               high--;
          }
    }
}