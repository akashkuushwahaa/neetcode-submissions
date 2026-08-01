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
    HashMap<Integer,Integer>map = new HashMap<>();
    int pin;int preorder[];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        return recurse(0,preorder.length-1);
    }
    TreeNode recurse(int left,int right)
    {
        if(left>right)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pin++]);
        int mid = map.get(root.val);

        root.left = recurse(left,mid-1);
        root.right = recurse(mid+1,right);

        return root;
    }
}