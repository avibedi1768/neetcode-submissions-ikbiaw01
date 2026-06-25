class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int a[] = new int[n], k = 0;

        for (int p : nums1)
            a[k++] = p;

        for (int p : nums2)
            a[k++] = p;

        Arrays.sort(a);

        if (n % 2 == 0) {
            return (a[n / 2] + a[n / 2 - 1]) / 2.0;
        } else {
            return a[n / 2];
        }

    }
}