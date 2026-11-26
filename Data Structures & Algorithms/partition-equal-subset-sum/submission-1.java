class Solution {
    Boolean dp[][];

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 == 1)
            return false;

        int n = nums.length;
        dp = new Boolean[n + 1][sum / 2 + 1];

        return func(nums, n, sum / 2);
    }

    boolean func(int nums[], int n, int target) {
        if (target == 0)
            return dp[n][target] = true;
        if (n == 0)
            return dp[n][target] = false;

        if (dp[n][target] != null)
            return dp[n][target];

        boolean a1 = false, a2 = false;

        // include
        if (target >= nums[n - 1])
            a1 = func(nums, n - 1, target - nums[n - 1]);

        // dont include
        a2 = func(nums, n - 1, target);

        return dp[n][target] = a1 | a2;
    }
}
