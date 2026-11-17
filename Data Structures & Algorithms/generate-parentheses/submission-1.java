class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        func("(", n - 1, n);
        return ans;
    }

    void func(String s, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(s);
        } else {
            if (open > 0)
                func(s + "(", open - 1, close);

            if (open < close)
                func(s + ")", open, close - 1);
        }
    }
}
