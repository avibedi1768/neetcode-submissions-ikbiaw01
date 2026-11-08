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
    List<Integer> al;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        al = new ArrayList<>();
        this.k = k;

        move(root);

        return al.get(k - 1);
    }

    void move(TreeNode root) {
        if (root != null) {
            if (al.size() < k) {
                move(root.left);
                al.add(root.val);
                move(root.right);
            }
        }
    }
}
