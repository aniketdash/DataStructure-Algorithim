/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> lookup ;
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        lookup = new HashMap<>();
        
        Node originalNode= head;
        Node newNode=new Node(originalNode.val);
        
        lookup.put(originalNode,newNode);
        while(originalNode!=null){
            newNode.random=helper(originalNode.random);
            newNode.next=helper(originalNode.next);
            
            originalNode=originalNode.next;
            newNode=newNode.next;
        }
        return lookup.get(head);
    }
    
    public Node helper(Node old){
       if(old!=null){
           if(lookup.containsKey(old))
               return lookup.get(old);
           else{
               Node node=new Node(old.val);
               lookup.put(old,node);
               return node;
           }
       }
       return null;    
    }
}