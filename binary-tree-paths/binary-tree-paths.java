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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> li = new ArrayList<>();
        helper(root,"",li);
        return li;
    }
    public void helper(TreeNode root,String path,List<String> li){
        if(root!=null){
            path+= String.valueOf(root.val);
            if(root.left==null && root.right==null)
                li.add(path);
            else{
                path+="->";
                helper(root.left,path,li);
                helper(root.right,path,li);
            }
        }
        
    }
}