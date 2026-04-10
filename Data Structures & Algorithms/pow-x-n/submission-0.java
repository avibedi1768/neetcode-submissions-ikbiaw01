class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        double power = n;

        if(n < 0)
            power *= -1;
        
        while(power > 0){
            if(power % 2 == 0){
                power /= 2;
                x *= x;
            }else{
                power--;
                ans *= x;
            }
        }

        return n < 0 ? 1 / ans : ans;
    }
}
