class Solution {
    public int getSum(int a, int b) {
        int ans = a ^ b;
        int carry = (a & b) << 1;
        
        while(carry != 0){
            int xor = ans ^ carry;
            carry = (ans & carry) << 1;

            ans = xor;
        }

        return ans;
    }
}
