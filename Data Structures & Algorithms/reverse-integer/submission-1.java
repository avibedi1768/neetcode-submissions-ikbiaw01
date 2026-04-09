class Solution {
    public int reverse(int x) {
        int sign = 1;
        long orig = x;

        if(orig < 0){
            sign = -1;
            orig *= -1;
        }

        long p = sign * Long.parseLong(new StringBuffer(orig + "").reverse().toString());

        if(p > Integer.MAX_VALUE || p < Integer.MIN_VALUE)
            return 0;
        
        return (int)p;
    }
}
