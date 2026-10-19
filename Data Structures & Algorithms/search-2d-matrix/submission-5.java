class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int beg = 0, end = m - 1;

        while (beg <= end) {
            int mid = (beg + end) / 2;

            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target)
                beg = mid + 1;
            else
                end = mid - 1;
        }

        // System.out.println(beg + " " + end);

        if(end < 0)
            return false;

        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[end][mid] == target)
                return true;
            else if (matrix[end][mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
