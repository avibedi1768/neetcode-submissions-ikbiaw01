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

    public boolean isValidBST(TreeNode root) {
        al = new ArrayList<>();

        move(root);

        List<Integer> sorted = new ArrayList<>(al);
        Set<Integer> hs = new HashSet(al);

        if (hs.size() != al.size())
            return false;

        Collections.sort(sorted);

        return sorted.equals(al);
    }

    void move(TreeNode root) {
        if (root != null) {
            move(root.left);
            al.add(root.val);
            move(root.right);
        }
    }
}
