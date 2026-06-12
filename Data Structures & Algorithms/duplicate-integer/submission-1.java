class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for(int p : nums)       
            if(!hs.add(p))
                return true;
            
        return false;
    }
}