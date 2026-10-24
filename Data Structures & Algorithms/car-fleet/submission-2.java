class Solution {
    int target;

    public int carFleet(int target, int[] position, int[] speed) {
        this.target = target;
        int n = position.length;
        int mat[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            mat[i][0] = position[i];
            mat[i][1] = speed[i];
        }

        Arrays.sort(mat, (a, b) -> a[0] - b[0]);

        // print(mat);

        Stack<Double> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            double time = (target - mat[i][0]) / (double) mat[i][1];

            if (st.isEmpty() || st.peek() < time)
                st.push(time);
        }

        return st.size();
    }

    void print(int a[][]) {
        for (int p[] : a)
            System.out.println(Arrays.toString(p) + " " + ((target - p[0]) / (double) p[1]));
    }
}

/*
0 1 4 7
1 2 2 1
*/