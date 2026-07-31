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
    public TreeNode find(TreeNode root , TreeNode p , TreeNode q){
         if(root == null){
            return root;
        }

        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left , p ,q);

        }
        else if(root.val<p.val && root.val<q.val){
           return lowestCommonAncestor(root.right , p, q);
        }
        else{
            return root;
        }

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return find(root , p ,q);
        
    }
}