class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];

        for (int p : nums) min = Math.min(min, p);

        return min;
    }
}
