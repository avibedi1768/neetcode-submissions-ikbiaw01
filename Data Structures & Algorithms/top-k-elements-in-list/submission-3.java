class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int p : nums)
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        
        int a = hm.size();
        int mat[][] = new int[a][2];
        int i = 0;

        for(int p : hm.keySet()) {
            mat[i][0] = p;
            mat[i][1] = hm.get(p);
            i++;
        }

        // for(int[] p : mat)
            // System.out.print(Arrays.toString(p) + " ");

        int ans[] = new int[k];

        Arrays.sort(mat, (p, q) -> q[1] - p[1]);

        for(i = 0; i < k; i++)
            ans[i] = mat[i][0];

        return ans;
    }
}
