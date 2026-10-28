class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        int left = 0, n = s.length(), ans = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            int max = 0;

            for (char p : hm.keySet()) max = Math.max(max, hm.get(p));

            while (right - left + 1 > max + k) {
                char c = s.charAt(left++);
                int rem = hm.get(c) - 1;

                if (rem == 0)
                    hm.remove(c);
                else
                    hm.put(c, rem);

                for (char p : hm.keySet()) max = Math.max(max, hm.get(p));
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
