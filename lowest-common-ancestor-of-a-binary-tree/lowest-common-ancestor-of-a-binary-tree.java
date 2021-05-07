/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> parentLkp;
    TreeNode fNode,sNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parentLkp=new HashMap<>();
        fNode=p;sNode=q;
        findParent(root,null);
        Set<TreeNode> ancestor=new HashSet<>();
        while(fNode!=null){
            ancestor.add(fNode);
            fNode=parentLkp.get(fNode);
        }
        while(!ancestor.contains(sNode))
            sNode=parentLkp.get(sNode);
        
        return sNode;
            
    }
    
    public void findParent(TreeNode root,TreeNode parent){
        if(root==null)
            return;
        if(parentLkp.containsKey(fNode) && parentLkp.containsKey(sNode))
            return;
        parentLkp.put(root,parent);
        if(root.left!=null){
           findParent(root.left,root);
        }
        if(root.right!=null){
            findParent(root.right,root);
        }
    }
}