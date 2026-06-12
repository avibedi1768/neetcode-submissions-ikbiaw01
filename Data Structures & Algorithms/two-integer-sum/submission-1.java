class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int rem = target - nums[i];

            if(hm.containsKey(rem)) {
                return new int[] {hm.get(rem), i};
            }

            if(!hm.containsKey(nums[i]))    
                hm.put(nums[i], i);
        }
    
        return new int[] {-1, -1};
    }
}
