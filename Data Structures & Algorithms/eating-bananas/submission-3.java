class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        long total = 0;

        for (int p : piles) total += p;

        long beg = 1, end = total, min = total;

        while (beg <= end) {
            long mid = beg + (end - beg) / 2;

            if (good(piles, h, mid)) {
                min = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }

            // System.out.println(min);
        }

        return (int) min;
    }

    boolean good(int piles[], int h, long curr) {
        long time = 0;

        for (int p : piles) {
            time += (long) Math.ceil(p / (double) curr);
        }
        // System.out.println(time + " " + curr);

        return time <= h;
    }
}
