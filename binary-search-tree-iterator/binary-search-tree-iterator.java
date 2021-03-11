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
class BSTIterator {
    List<Integer> li;
    int index;

    public BSTIterator(TreeNode root) {
        li=new ArrayList<>();
        TreeNode curr=root;
        TreeNode pre=null;
        while(curr!=null){
            if(curr.left==null){
                li.add(curr.val);
                curr=curr.right;
            }else{
            pre=curr.left;
            while(pre.right!=null)
                pre=pre.right;
                
            pre.right=curr;
            TreeNode temp=curr;
            curr=curr.left;
            temp.left=null;  
            }
        }
        index=0;
    }
    
    public int next() {
        return li.get(index++);
    }
    
    public boolean hasNext() {
        if(index<li.size())
            return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */