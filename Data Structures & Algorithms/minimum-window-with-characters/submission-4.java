class Solution {
    public String minWindow(String s, String t) {
        int freq1[] = new int[52], freq2[] = new int[52];
        int n1 = s.length(), n2 = t.length(), left = 0;
        String ans = "";

        if (n1 < n2)
            return "";

        for (int i = 0; i < n2; i++) {
            char c1 = s.charAt(i);

            if (c1 >= 'a' && c1 <= 'z')
                freq1[c1 - 'a']++;
            else
                freq1[c1 - 'A' + 26]++;

            char c2 = t.charAt(i);

            if (c2 >= 'a' && c2 <= 'z')
                freq2[c2 - 'a']++;
            else
                freq2[c2 - 'A' + 26]++;
        }

        if (Arrays.equals(freq1, freq2))
            return s.substring(0, n2);

        for (int i = n2; i < n1; i++) {
            char c1 = s.charAt(i);

            if (c1 >= 'a' && c1 <= 'z')
                freq1[c1 - 'a']++;
            else
                freq1[c1 - 'A' + 26]++;

            while (good(freq1, freq2)) {
                if (ans == "" || ans.length() > i - left + 1)
                    ans = s.substring(left, i + 1);

                char c2 = s.charAt(left);

                if (c2 >= 'a' && c2 <= 'z')
                    freq1[c2 - 'a']--;
                else
                    freq1[c2 - 'A' + 26]--;

                left++;
            }
        }

        return ans;
    }

    boolean good(int f1[], int f2[]) {
        for (int i = 0; i < 52; i++)
            if (f1[i] < f2[i])
                return false;

        return true;
    }
}
