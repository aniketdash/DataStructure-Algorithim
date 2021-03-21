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
    int preIndex=0;
    Map<Integer,Integer> inorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndex=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i],i);
        }
        
        return helper(preorder,inorder,0,preorder.length-1);
    }
    
    public TreeNode helper(int[] preorder,int[] inorder, int left,int right){
        if(left>right)
            return null;
        
        int val=preorder[preIndex++];
        TreeNode root=new TreeNode(val);
        
        root.left=helper(preorder,inorder,left,inorderIndex.get(root.val)-1);
        root.right=helper(preorder,inorder,inorderIndex.get(root.val)+1,right);
        return root;
    }
}