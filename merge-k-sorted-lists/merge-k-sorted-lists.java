/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1){
            return lists[0];
        }
        if(lists.length==0)
            return null;
        
        ListNode head= mergeList(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){
            head=mergeList(head,lists[i]);
        }
        return head;
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode h= new ListNode(0);
        ListNode node=h;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                h.next=l1;
                h=h.next;
                l1=l1.next;
            }else{
                h.next=l2;
                h=h.next;
                l2=l2.next;
            }
        }
        h.next= l1==null?l2:l1;
        return node.next;
    }
}