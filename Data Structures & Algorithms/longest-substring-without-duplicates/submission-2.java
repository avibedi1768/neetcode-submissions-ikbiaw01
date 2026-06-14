class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int n = s.length(), ans = 0, left = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            while (hm.size() != right - left + 1) {
                ch = s.charAt(left);
                int rem = hm.get(ch) - 1;

                if (rem == 0)
                    hm.remove(ch);
                else
                    hm.put(ch, rem);

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
