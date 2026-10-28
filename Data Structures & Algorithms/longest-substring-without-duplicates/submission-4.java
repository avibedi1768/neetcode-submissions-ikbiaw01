class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        int left = 0, n = s.length(), ans = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            while (hm.size() != right - left + 1) {
                char c = s.charAt(left++);
                int rem = hm.get(c) - 1;

                if (rem == 0)
                    hm.remove(c);
                else
                    hm.put(c, rem);
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
