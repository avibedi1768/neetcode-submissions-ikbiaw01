class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int a[] = new int[m + n];
        int k = 0, i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                a[k++] = nums1[i++];
            } else {
                a[k++] = nums2[j++];
            }
        }

        while (i < m) a[k++] = nums1[i++];

        while (j < n) a[k++] = nums2[j++];

        if (k % 2 == 0)
            return (a[k / 2] + a[k / 2 - 1]) / 2.0;
        else
            return a[k / 2];
    }
}
