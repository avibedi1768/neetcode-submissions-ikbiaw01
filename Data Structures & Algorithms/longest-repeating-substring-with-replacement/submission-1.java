class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length(), left = 0;
        int freq[] = new int[26];

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            int curr = freq[ch - 'A'];
            char max = ch;

            for (int i = 0; i < 26; i++) {
                if (curr < freq[i]) {
                    curr = freq[i];
                    max = (char) ('A' + i);
                }
            }

            while (right - left + 1 > k + curr) {
                ch = s.charAt(left++);
                freq[ch - 'A']--;
            }

            ans = Math.max(right - left + 1, ans);
        }

        return ans;
    }
}
