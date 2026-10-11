class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch) || Character.isDigit(ch))
                sb.append(ch);
        }

        // System.out.println(sb);
        s = sb.toString();

        return s.equals(sb.reverse().toString());
    }
}
