class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int i = Integer.MIN_VALUE, j = i, k = i;

        for (int p[] : triplets) {
            if (p[0] > target[0] || p[1] > target[1] || p[2] > target[2])
                continue;
            
            // System.out.println(Arrays.toString(p));

            i = Math.max(i, p[0]);
            j = Math.max(j, p[1]);
            k = Math.max(k, p[2]);
        }

        return i == target[0] && j == target[1] && k == target[2];
    }
}
