class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toUpperCase();

        while(left < right) {
            while(left < s.length() && !(Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left))))
                left++;
            
            while(right > 0 && !(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right))))
                right--;
            
            if(left >= right)
                break;
            
            if(s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
        }

        return true;
    }
}
