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
    List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();

        move(root, 0);

        return ans;
    }

    void move(TreeNode root, int level) {
        if (root != null) {
            if (ans.size() <= level)
                ans.add(new ArrayList<>());

            move(root.left, level + 1);

            ans.get(level).add(root.val);

            move(root.right, level + 1);
        }
    }
}