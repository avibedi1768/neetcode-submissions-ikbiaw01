class Solution {
    Integer dp[];

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new Integer[n + 1];

        int a1 = func(nums, n), a2 = func(nums, n - 1);

        return Math.max(a1, a2);
    }

    int func(int nums[], int n) {
        if (n == 0)
            return dp[n] = 0;
        if (n == 1)
            return dp[n] = nums[0];
        if (n == 2)
            return dp[n] = Math.max(nums[0], nums[1]);

        if (dp[n] != null)
            return dp[n];

        int a1 = nums[n - 1] + func(nums, n - 2);
        int a2 = nums[n - 1] + func(nums, n - 3);

        return dp[n] = Math.max(a1, a2);
    }
}
