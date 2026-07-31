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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        return dfs(root, subroot);
    }
    public boolean dfs(TreeNode root, TreeNode subroot) {
        if(root == null) {
            return false;
        }
        boolean flag = false;
        if(root.val == subroot.val) {
            flag |= inorder(root, subroot);
        }
        flag |= dfs(root.left, subroot) || dfs(root.right, subroot); 
        return flag;
    }

    public boolean inorder(TreeNode root, TreeNode subroot) {
        if(root == null && subroot == null) {
            return true;
        }
        if(root == null || subroot == null) {
            return false;
        }
        if(root.val != subroot.val) {
            return false;
        }
        return  inorder(root.left, subroot.left) && inorder(root.right, subroot.right);
    }
}