class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long max = Arrays.stream(piles).max().getAsInt();

        long beg = 1, end = max, ans = max;

        while (beg <= end) {
            long mid = beg + (end - beg) / 2;

            if (check(piles, mid, h)) {
                ans = mid;

                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }

        return (int) ans;
    }

    boolean check(int piles[], long mid, long h) {
        long sum = 0;

        for (int p : piles) {
            sum += (long) Math.ceil(p / (double) mid);
        }

        // System.out.println(sum + " " + mid);
        return sum <= h;
    }
}
