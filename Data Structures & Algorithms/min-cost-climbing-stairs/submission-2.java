class Solution {
    Integer dp[];

    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length + 1];

        int a1 = func(cost, 0);
        int a2 = func(cost, 1);

        return Math.min(a1, a2);
    }

    int func(int nums[], int i) {
        if (i == nums.length)
            return dp[i] = 0;

        if (dp[i] != null)
            return dp[i];

        int a1 = Integer.MAX_VALUE, a2 = a1;

        // i+1
        a1 = nums[i] + func(nums, i + 1);

        // i+2
        if (i + 2 <= nums.length)
            a2 = nums[i] + func(nums, i + 2);

        return dp[i] = Math.min(a1, a2);
    }
}
