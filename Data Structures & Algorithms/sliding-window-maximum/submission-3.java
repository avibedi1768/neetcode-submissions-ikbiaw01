class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++) pq.add(new int[] {nums[i], i});

        

        int n = nums.length;
        int ans[] = new int[n - k + 1];

        ans[0] = pq.peek()[0];

        for (int i = k; i < n; i++) {
            pq.add(new int[] {nums[i], i});
            // System.out.println("helo " + i);

            while (!pq.isEmpty() && pq.peek()[1] <= i - k) {
                // System.out.println(Arrays.toString(pq.peek()));
                // System.out.println("helo");

                pq.remove();
            };

            // for (int[] p : pq) System.out.print(Arrays.toString(p) + " ");

            // System.out.println();

            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }
}
