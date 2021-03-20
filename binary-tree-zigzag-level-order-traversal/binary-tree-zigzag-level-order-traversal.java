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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if(root==null)
           return new ArrayList<>();
       Queue<TreeNode> q= new LinkedList<>();
       LinkedList<Integer> zig=new LinkedList<>();
       List<List<Integer>> li=new ArrayList<>(); 
        int roundCount=0;
       q.offer(root);
       q.offer(null);
       while(q.size()>0){
           TreeNode curr=q.poll();
           if(curr!=null){
               if(roundCount%2==0)
                   zig.addLast(curr.val);
               else
                   zig.addFirst(curr.val);
               if(curr.left!=null)
                   q.offer(curr.left);
               if(curr.right!=null)
                   q.offer(curr.right);
           }else{
               li.add(zig);
               zig= new LinkedList<>();
               if(q.size()>0)
                   q.offer(null);
               roundCount++;
           }
       }
       return li; 
    }
}