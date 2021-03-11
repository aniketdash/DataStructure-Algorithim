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
    //Recursive Solution
    List<Integer> li;
    public List<Integer> inorderTraversal(TreeNode root) {
        li=new ArrayList<>();
        helper(root);
        return li;
    }
    
    public void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        li.add(root.val);
        helper(root.right);
    }
}