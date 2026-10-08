class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n <= 1)
            return n;

        Arrays.sort(nums);

        int max = 1, curr = nums[0], seq = 1;

        for (int p : nums) {
            if (curr == p)
                continue;

            if (curr + 1 == p) {
                seq++;
                max = Math.max(max, seq);
                curr = p;
            } else {
                seq = 1;
                curr = p;
            }
        }

        return max;
    }
}
