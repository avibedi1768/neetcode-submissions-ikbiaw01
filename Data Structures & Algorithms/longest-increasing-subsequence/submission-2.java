class Solution {
    Integer dp[][];

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n + 1][n + 1];

        return func(nums, n, n);
    }

    int func(int nums[], int n, int prev) {
        if (n == 0)
            return dp[n][prev] = 0;

        if (dp[n][prev] != null)
            return dp[n][prev];

        int a1 = 0, a2 = 0, i = n - 1;

        // include
        if (prev == nums.length || nums[i] < nums[prev])
            a1 = 1 + func(nums, n - 1, i);

        // dont include
        a2 = func(nums, n - 1, prev);

        return dp[n][prev] = Math.max(a1, a2);
    }
}
