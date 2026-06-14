class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], ans = 0;

        for (int p : prices) {
            min = Math.min(min, p);
            ans = Math.max(ans, p - min);
        }

        return ans;
    }
}
