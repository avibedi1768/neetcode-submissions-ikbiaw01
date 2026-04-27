/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int start[] = new int[n], end[] = new int[n];
        int i = 0;

        for(Interval p : intervals) {
            start[i] = p.start;
            end[i] = p.end;
            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0, ans = 0, j = 0;
        i = 0;

        while(i < n && j < n) {
            if(start[i] < end[j]) {
                count++;
                i++;
            } else if(start[i] > end[j]) {
                count--;
                j++;
            } else{
                // do nothing. same start, end
                i++;
                j++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
