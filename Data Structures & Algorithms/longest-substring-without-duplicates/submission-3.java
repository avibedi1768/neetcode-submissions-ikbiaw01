class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        int left = 0, n = s.length(), ans = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            while (hm.containsKey(ch)) hm.remove(s.charAt(left++));

            hm.put(ch, 1);

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
