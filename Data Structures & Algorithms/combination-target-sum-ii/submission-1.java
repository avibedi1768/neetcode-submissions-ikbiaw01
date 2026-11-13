class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();

        func(candidates, target, 0, new ArrayList<>());

        return ans;
    }

    void func(int nums[], int target, int i, List<Integer> al) {
        if (target == 0)
            ans.add(new ArrayList<>(al));
        else if (i == nums.length) {
            // do nothing
            // System.out.println("yo");
        } else {
            for (int j = i; j < nums.length; j++) {
                if (j > i && nums[j] == nums[j - 1])
                    continue;

                if (nums[j] <= target) {
                    al.add(nums[j]);
                    func(nums, target - nums[j], j + 1, al);
                    al.remove(al.size() - 1);
                }
            }
        }
    }
}
