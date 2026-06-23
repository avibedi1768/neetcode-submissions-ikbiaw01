class Solution {
    public int largestRectangleArea(int[] heights) {
        int nse[] = nse(heights);
        int pse[] = pse(heights);

        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(pse));

        int ans = 0, n = heights.length;

        for (int i = 0; i < n; i++) {
            // current pillar di height nal dekhoo max area
            int curr = ((nse[i] - 1) - (pse[i] + 1) + 1) * heights[i];
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    int[] nse(int a[]) {
        int n = a.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i])
                st.pop();

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] pse(int a[]) {
        int n = a.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i])
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }
}

/**
2, 1, 5, 6, 2, 3
_, _, 1, 5, 1, 2
1, _, 2, 2, _, 3
 */