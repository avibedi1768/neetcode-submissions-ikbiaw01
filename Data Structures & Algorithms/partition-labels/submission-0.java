class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int last[] = new int[26];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++)
            last[s.charAt(i) - 'a'] = i;

        // System.out.println(Arrays.toString(last));

        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            int end = last[ch - 'a'];

            for (int j = i + 1; j < end; j++) {
                char curr = s.charAt(j);

                if (last[curr - 'a'] > end)
                    end = last[curr - 'a'];
            }

            ans.add(end - i + 1);
            i = end + 1;
        }

        return ans;
    }
}
