class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int left = 0, n = s.length(), ans = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            freq[ch - 'A']++;

            int max = 0;

            for (int p : freq) max = Math.max(max, p);

            while (right - left + 1 > max + k) {
                char c = s.charAt(left++);
                freq[c - 'A']--;

                for (int p : freq) max = Math.max(max, p);
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
