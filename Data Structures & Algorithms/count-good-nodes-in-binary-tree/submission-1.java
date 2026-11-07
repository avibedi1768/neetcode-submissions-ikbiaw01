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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;

        move(root, Integer.MIN_VALUE);

        return count;
    }

    void move(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max)
                count++;

            move(root.left, Math.max(max, root.val));
            move(root.right, Math.max(root.val, max));
        }
    }
}
