class Solution {
    public int longestConsecutive(int[] nums) {
        int n = n = nums.length;
        if (n <= 1)
            return n;

        Arrays.sort(nums);
        int ans = 1, prev = nums[0], curr = 1;

        // System.out.println(Arrays.toString(nums));

        for (int i = 1; i < n; i++) {
            if (prev + 1 == nums[i]) {
                curr++;
                prev++;

                ans = Math.max(ans, curr);
            } else if (prev == nums[i]) {
                continue;
            } else {
                curr = 1;
                prev = nums[i];
            }
        }

        return ans;
    }
}
