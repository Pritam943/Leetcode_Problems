class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;

        int[] ans = new int[2];

        while(low <= high){

            int mid = low + (high - low)/2;

            int row = findMaxRow(mat, mid, n);

            int left = (mid - 1 >= 0) ? mat[row][mid-1] : -1;
            int right = (mid + 1 < m) ? mat[row][mid+1] : -1;

            if(left < mat[row][mid] && mat[row][mid] > right){
                return new int[]{row, mid};
            }
            else if(left > mat[row][mid]){
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }

        return new int[]{-1, -1};
        
    }

    public int findMaxRow(int[][] mat, int col, int n){

        int max = Integer.MIN_VALUE;
        int maxRow = -1;

        for(int i=0; i<n; i++){
            
            if(mat[i][col] > max){
                max = Math.max(max, mat[i][col]);
                maxRow = i;
            }
        }

        return maxRow;
    }
}