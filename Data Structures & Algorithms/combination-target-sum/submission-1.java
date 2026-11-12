class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();

        func(nums, 0, target, new ArrayList<>());

        return ans;
    }

    void func(int nums[], int i, int target, List<Integer> al) {
        if (i == nums.length) {
            if (target == 0)
                ans.add(new ArrayList<>(al));
        } else {
            if (target >= nums[i]) {
                al.add(nums[i]);
                func(nums, i, target - nums[i], al);
                al.remove(al.size() - 1);
            }

            func(nums, i + 1, target, al);
        }
    }
}
