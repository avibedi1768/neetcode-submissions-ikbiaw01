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
    List<List<Integer>> levels;

    public List<Integer> rightSideView(TreeNode root) {
        levels = new ArrayList<>();

        move(root, 0);

        List<Integer> ans = new ArrayList<>();

        for (List<Integer> level : levels) {
            ans.add(level.get(level.size() - 1));
        }

        return ans;
    }

    void move(TreeNode root, int level) {
        if (root != null) {
            if (levels.size() <= level)
                levels.add(new ArrayList<>());

            move(root.left, level + 1);

            levels.get(level).add(root.val);

            move(root.right, level + 1);
        }
    }
}
