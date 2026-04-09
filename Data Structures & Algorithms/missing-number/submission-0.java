class Solution {
    public int missingNumber(int[] nums) {
           int  a1 = 0, a2 = 0;

            for(int p : nums)
                a1 ^= p;
            
            for(int i = 0; i <= nums.length; i++)
                a2 ^= i;

           return a1 ^ a2;
    }
}
