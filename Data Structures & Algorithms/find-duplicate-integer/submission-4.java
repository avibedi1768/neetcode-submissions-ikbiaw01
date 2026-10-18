class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean a[] = new boolean[n + 1];

        for (int p : nums) {
            if (a[p])
                return p;

            a[p] = true;
        }

        return -1;
    }
}
