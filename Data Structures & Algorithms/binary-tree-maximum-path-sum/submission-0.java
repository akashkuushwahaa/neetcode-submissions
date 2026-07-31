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
    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        ans(root);
        return sum ;
    }
    
    public int ans(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0 , ans(root.left));
        int rightSum = Math.max(0 , ans(root.right));
        sum = Math.max(sum , leftSum + rightSum + root.val);
        return root.val + Math.max(leftSum , rightSum); 
    }
}
