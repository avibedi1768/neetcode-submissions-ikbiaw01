class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int beg = 0, end = m - 1;

        while (beg <= end) {
            int mid = (beg + end) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                beg = 0;
                end = n - 1;

                while (beg <= end) {
                    int mid2 = (beg + end) / 2;

                    if (matrix[mid][mid2] == target)
                        return true;
                    else if (matrix[mid][mid2] > target)
                        end = mid2 - 1;
                    else
                        beg = mid2 + 1;
                }

                break;
            } else if (matrix[mid][0] > target)
                end = mid - 1;
            else
                beg = mid + 1;
        }

        return false;
    }
}
