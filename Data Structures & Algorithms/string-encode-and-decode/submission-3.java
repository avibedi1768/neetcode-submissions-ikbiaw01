class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for(String s : strs) {
            if(s.length() == 0) {
                sb.append("0.");
                continue;
            }

            int len = s.length();
            sb.append(len);
            sb.append('.');
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        // System.out.println(str);

        int i = 0;
        while(i < str.length()) {
            int ind = str.indexOf('.', i);
            // System.out.println(i + " " + ind);
            int len = Integer.parseInt(str.substring(i, ind));

            String curr = str.substring(ind + 1, ind + 1 + len);
            ans.add(curr);

            i = ind + 1 + len;
        }

        return ans;
    }
}
