class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        int sum = 1 + digits[n - 1];

        // no carry. easy life
        if(sum <= 9){
            digits[n - 1]++;
            return digits;
        }

        // just 1 element, again easy life
        if(n == 1){
            return new int[] {1, 0};
        }

        // reality hits
        int carry = 1;
        int curr[] = new int[n + 1];
        curr[n] = 0;
        digits[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--){
            sum = carry + digits[i];
            curr[i + 1] = sum % 10;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry > 0){
            curr[0] = carry;
            return curr;
        }else{
            return digits;
        }
    }
}
