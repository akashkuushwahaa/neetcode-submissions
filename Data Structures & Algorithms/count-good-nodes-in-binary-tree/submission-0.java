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
    int goodNode = 0;

    public int goodNodes(TreeNode root) {
        solve(root, root.val);
        return goodNode;
    }

    public int solve(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int m = Math.max(max, root.val);
        if (root.val >= max) {
            goodNode++;
        }
        solve(root.left, m);
        solve(root.right, m);
        return goodNode;
    }
}
