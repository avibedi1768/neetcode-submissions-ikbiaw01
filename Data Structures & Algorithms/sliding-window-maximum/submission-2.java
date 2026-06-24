class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.length;
        int ans[] = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            pq.add(new int[] {nums[i], i});
        }
        // print(pq);

        int curr[] = pq.peek();
        ans[0] = curr[0];

        for (int i = k; i < n; i++) {
            pq.add(new int[] {nums[i], i});

            while (!pq.isEmpty() && pq.peek()[1] <= i - k) pq.remove();

            // print(pq);

            curr = pq.peek();
            ans[i - k + 1] = curr[0];
        }

        return ans;
    }

    void print(PriorityQueue<int[]> pq) {
        for (int[] p : pq) {
            System.out.print(Arrays.toString(p) + " ");
        }

        System.out.println();
    }
}
