class Solution {
    public String encode(List<String> strs) {
        StringBuffer s = new StringBuffer();

        for (String p : strs) {
            int i = p.length();
            s.append(i + "#" + p);
        }

        // System.out.println(s);

        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        if (str.length() == 0) {
            return ans;
        }

        int curr = 0;

        while (true) {
            int next = str.indexOf("#", curr + 1);

            String len = str.substring(curr, next);
            int n = Integer.parseInt(len);

            String sub = str.substring(curr + 1 + len.length(), next + n + 1);

            // System.out.println(len + " " + sub);

            curr = next + n + 1;
            ans.add(sub);

            if (curr >= str.length() - 1)
                break;
        }

        return ans;
    }
}
