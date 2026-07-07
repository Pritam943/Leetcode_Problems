class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList<Integer> ansList = new ArrayList<>();

        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = m - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {

                ansList.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {

                ansList.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {

                    ansList.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {

                    ansList.add(matrix[i][left]);
                }
                left++;
            }

        }

        return ansList;

    }
}