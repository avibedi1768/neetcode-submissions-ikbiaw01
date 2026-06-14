class Solution {
    public int maxArea(int[] heights) {
        int beg = 0, end = heights.length - 1;
        int ans = 0;

        while(beg < end) {
            int diff = end - beg;
            ans = Math.max(ans, diff * Math.min(heights[beg], heights[end]));

            if(heights[beg] < heights[end])
                beg++;
            else
                end--;
        }

        return ans;
    }
}
