class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        func(nums, new ArrayList<>());
        return ans;
    }

    void func(int nums[], List<Integer> al) {
        if (nums.length == 0) {
            ans.add(new ArrayList<>(al));
        } else {
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                int next[] = new int[n - 1];
                int k = 0;

                for (int j = 0; j < n; j++)
                    if (i != j)
                        next[k++] = nums[j];

                al.add(nums[i]);
                func(next, al);
                al.remove(al.size() - 1);
            }
        }
    }
}
