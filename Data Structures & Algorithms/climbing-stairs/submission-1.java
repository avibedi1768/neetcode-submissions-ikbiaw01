class Solution {
    Integer dp[];

    public int climbStairs(int n) {
        dp = new Integer[n + 1];

        return move(n);
    }

    int move(int n) {
        if (n == 0)
            return dp[n] = 1;

        if (dp[n] != null)
            return dp[n];

        int a1 = 0, a2 = 0;

        a1 = move(n - 1);

        if (n >= 2)
            a2 = move(n - 2);

        return dp[n] = a1 + a2;
    }
}