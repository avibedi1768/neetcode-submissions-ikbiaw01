class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> hm = new HashMap<>();

        for (int p[] : intervals) {
            int len = p[1] - p[0] + 1;

            for (int i = p[0]; i <= p[1]; i++) {
                hm.put(i, Math.min(len, hm.getOrDefault(i, len)));
            }
        }

        // System.out.println(hm);

        int n = queries.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++)
            ans[i] = hm.getOrDefault(queries[i], -1);

        return ans;
    }
}
