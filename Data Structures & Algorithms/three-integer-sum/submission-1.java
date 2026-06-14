class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i - 1] == nums[i])
                continue;

            int beg = i + 1, end = n - 1;

            while(beg < end) {
                int sum = nums[i] + nums[beg] + nums[end];

                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[beg], nums[end]));

                    while(beg < end && nums[beg] == nums[beg + 1])
                        beg++;
                    
                    beg++;

                    while(beg < end && nums[end - 1] == nums[end])
                        end--;
                    
                    end--;
                }else if(sum > 0) {
                    end--;
                } else {
                    beg++;
                }
            }
        }

        return ans;
    }
}
