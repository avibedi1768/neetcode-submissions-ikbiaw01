class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet();

        for (int p : nums)
            if (!hs.add(p))
                return p;

        return -1;
    }
}
