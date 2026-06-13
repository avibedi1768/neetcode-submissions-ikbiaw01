class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int p : nums)
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        
        int freq[][] = new int[hm.size()][2], i = 0;

        for(int p : hm.keySet()) {
            freq[i][0] = p;
            freq[i][1] = hm.get(p);

            i++;
        }

        Arrays.sort(freq, (a, b) -> b[1] - a[1]);

        int ans[] = new int[k];

        for(int j = 0; j < k; j++)
            ans[j] = freq[j][0];
        
        return ans;
    }
}
