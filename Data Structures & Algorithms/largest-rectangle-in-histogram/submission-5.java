class Solution {
    public int largestRectangleArea(int[] heights) {
        int nse[] = nse(heights);
        int pse[] = pse(heights);

        // System.out.println(Arrays.toString(nse));
        // System.out.println(Arrays.toString(pse));

        int max = 0, n = heights.length;

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max, area);

            // System.out.println(heights[i] + " " + area);
        }

        return max;
    }

    int[] nse(int a[]) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int b[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();

            if (st.isEmpty())
                b[i] = n;
            else
                b[i] = st.peek();

            st.push(i);
        }

        return b;
    }

    int[] pse(int a[]) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int b[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();

            if (st.isEmpty())
                b[i] = -1;
            else
                b[i] = st.peek();

            st.push(i);
        }

        return b;
    }
}
