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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,0,targetSum);
    }
    
    public boolean helper(TreeNode root, int sum,int targetSum){
        if(root==null)
            return false;
        if(root.left==null && root.right==null && (sum+root.val)==targetSum)
            return true;
        return helper(root.left,sum+root.val,targetSum) || helper(root.right,sum+root.val,targetSum);
    }
}