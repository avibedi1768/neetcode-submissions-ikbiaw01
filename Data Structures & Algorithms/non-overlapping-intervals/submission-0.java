class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int count = 0;
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int p[] = intervals[i];

            // remove the point, whose end is bigger.
            if (p[0] < end) {
                if (p[1] > end) {
                    // remove the current p. no changes in start, end
                } else if (p[1] <= end) {
                    // remove prev
                    start = p[0];
                    end = p[1];
                }

                count++;
            } else {
                start = p[0];
                end = p[1];
            }
        }

        return count;

    }
}
