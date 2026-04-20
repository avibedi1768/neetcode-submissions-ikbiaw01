class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0, n = intervals.length;
        int start = intervals[0][0], end = intervals[0][1];

        for(int i = 1; i < n; i++) {
            int p[] = intervals[i];

            if(end > p[0]) {
                count++;

                if(p[1] > end) {
                    // dont change start, end. delete curr 
                } else {
                    end = p[1];
                }
            } else {
                start = p[0];
                end = p[1];
            }
        }

        return count;
    }
}
