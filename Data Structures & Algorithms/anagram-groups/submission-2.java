class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> hm = new HashMap<>();

        for(String p : strs) {
            char ch[] = p.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            if(!hm.containsKey(s))
                hm.put(s, new ArrayList<>());
            
            hm.get(s).add(p);
        }

        // System.out.println(hm);

        for(String p : hm.keySet()) {
            List<String> al = new ArrayList<>();
            
            for(String s : hm.get(p))
                al.add(s);
            
            ans.add(al);
        }

        return ans;
    }
}
