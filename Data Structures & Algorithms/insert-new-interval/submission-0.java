class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int mat[][] = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            mat[i][0] = intervals[i][0];
            mat[i][1] = intervals[i][1];
        }

        mat[n][0] = newInterval[0];
        mat[n][1] = newInterval[1];

        intervals = mat;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> al = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 0; i < n + 1; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                al.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        al.add(new int[] { start, end });

        int len = al.size();
        int ans[][] = new int[len][2], k = 0;

        for (int[] p : al) {
            ans[k][0] = p[0];
            ans[k++][1] = p[1];
        }

        return ans;
    }
}
