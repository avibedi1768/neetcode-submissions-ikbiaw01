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
    public int goodNodes(TreeNode root) {
        return move(root, root.val);
    }

    int move(TreeNode root, int max) {
        if (root == null)
            return 0;

        int neis =
            move(root.left, Math.max(root.val, max)) + move(root.right, Math.max(root.val, max));

        if (root.val >= max)
            return neis + 1;
        else
            return neis;
    }
}
