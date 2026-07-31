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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
        queue.offer(root);
        }
        while(!queue.isEmpty()){
            List<Integer> list1=new ArrayList<>();
            int curr=queue.size();
            for(int i=0;i<curr;i++){
                TreeNode now=queue.poll();
                list1.add(now.val);
                if(now.left!=null)queue.offer(now.left);
                if(now.right!=null) queue.offer(now.right);
            }
            list.add(list1);
        }
        return list;
    }
}