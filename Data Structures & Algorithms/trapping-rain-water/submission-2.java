class Solution {
    public int trap(int[] height) {
        int ans = 0, n = height.length;

        int left = 0, right = n - 1;
        int left_max = height[0], right_max = height[n - 1];

        while(left < right) {
            if(height[left] < height[right]) {
                int i = left + 1;
                ans += Math.max(0, Math.min(left_max, right_max) - height[i]);
                left++;
                left_max = Math.max(left_max, height[left]);
            } else {
                int i = right - 1;
                ans += Math.max(0, Math.min(left_max, right_max) - height[i]);
                right--;
                right_max = Math.max(right_max, height[right]);
            }
        }

        return ans;
    }
}
