class Solution {
    char grid[][];
    List<String> ans;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        grid = new char[][] {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        func(digits, 0, "");
        return ans;
    }

    void func(String s, int i, String curr) {
        if (i == s.length()) {
            ans.add(curr);
        } else {
            char ch = s.charAt(i);

            for (int k = 0; k < grid[ch - '0' - 2].length; k++)
                func(s, i + 1, curr + grid[ch - '0' - 2][k]);
        }
    }
}
