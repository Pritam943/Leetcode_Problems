class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = foundMaxRow(mat, mid, n);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < m ? mat[row][mid + 1] : -1;

            if (left < mat[row][mid] && mat[row][mid] > right) {
                return new int[] { row, mid };
            }

            else if (left > mat[row][mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return new int[] { -1, -1 };

    }

    public int foundMaxRow(int[][] mat, int m, int n) {

        int maxEle = Integer.MIN_VALUE;
        int maxI = -1;

        for (int i = 0; i < n; i++) {

            if (mat[i][m] > maxEle) {
                maxEle = Math.max(maxEle, mat[i][m]);
                maxI = i;
            }

        }

        return maxI;
    }
}