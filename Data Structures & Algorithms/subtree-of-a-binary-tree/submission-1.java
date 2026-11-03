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
    boolean ans;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ans = false;
        move(root, subRoot);

        return ans;
    }

    void move(TreeNode root, TreeNode sub) {
        if (root == null || sub == null)
            return;

        if (root.val == sub.val) {
            if (equal(root, sub)) {
                ans = true;
                return;
            }
        }

        move(root.left, sub);
        move(root.right, sub);
    }

    boolean equal(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        if (t1.val != t2.val)
            return false;

        return equal(t1.left, t2.left) && equal(t1.right, t2.right);
    }
}
