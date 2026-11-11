class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();

        func(nums, 0, new ArrayList<>());

        return ans;
    }

    void func(int nums[], int i, List<Integer> al) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(al));
        } else {
            func(nums, i + 1, al);

            al.add(nums[i]);
            func(nums, i + 1, al);

            al.remove(al.size() - 1);
        }
    }
}
