class Solution {
    Set<List<Integer>> hs;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        hs = new HashSet<>();
        Arrays.sort(nums);

        func(nums, 0, new ArrayList<>());

        return new ArrayList<>(hs);
    }

    void func(int nums[], int i, List<Integer> al) {
        if (i == nums.length) {
            hs.add(new ArrayList<>(al));
        } else {
            func(nums, i + 1, al);

            al.add(nums[i]);
            func(nums, i + 1, al);
            al.remove(al.size() - 1);
        }
    }
}
