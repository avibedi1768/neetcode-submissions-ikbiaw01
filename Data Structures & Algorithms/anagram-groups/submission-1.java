class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> hm = new HashMap<>();

        // Set<String> hs = new HashSet();

        // hs.add(new String("hey"));
        // hs.add(new String("hey"));

        // System.out.println(hs);

        for (String p : strs) {
            char a[] = p.toCharArray();
            Arrays.sort(a);
            String temp = new String(a);

            // System.out.println(p + " " + temp);

            if(!hm.containsKey(temp))
                hm.put(temp, new ArrayList<>());

            hm.get(temp).add(p);
        }

        // System.out.println(hm);

        for(String p : hm.keySet())
            ans.add(hm.get(p));

        return ans;
    }
}
