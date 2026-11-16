/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        func(root);
        return ans;
    }

    int func(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(func(root.left), 0);
        int right = Math.max(func(root.right), 0);

        int total = left + root.val + right;
        ans = Math.max(ans, total);

        return Math.max(left + root.val, root.val + right);
    }
}
