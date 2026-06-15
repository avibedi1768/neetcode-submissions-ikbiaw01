class Solution {
    public String minWindow(String s, String t) {
        int f1[] = new int[52], f2[] = new int[52];
        int n1 = s.length(), n2 = t.length();

        if (n1 < n2)
            return "";

        for (int i = 0; i < n2; i++) {
            char ch = t.charAt(i);

            if (ch >= 'a' && ch <= 'z')
                f2[ch - 'a']++;
            else
                f2[ch - 'A' + 26]++;
        }

        int left = 0;
        String ans = null;

        for (int right = 0; right < n1; right++) {
            char ch = s.charAt(right);

            if (ch >= 'a' && ch <= 'z')
                f1[ch - 'a']++;
            else
                f1[ch - 'A' + 26]++;

            while (good(f1, f2)) {
                if (ans == null || right - left + 1 < ans.length())
                    ans = s.substring(left, right + 1);

                ch = s.charAt(left++);

                if (ch >= 'a' && ch <= 'z')
                    f1[ch - 'a']--;
                else
                    f1[ch - 'A' + 26]--;
            }
        }

        return ans == null ? "" : ans;
    }

    boolean good(int a1[], int a2[]) {
        for (int i = 0; i < 52; i++)
            if (a1[i] < a2[i])
                return false;

        return true;
    }
}
