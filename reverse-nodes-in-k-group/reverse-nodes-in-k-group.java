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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead= new ListNode(0);
        dummyHead.next=head;
        ListNode pointer=dummyHead;
        while(pointer!=null){
            ListNode node=pointer;
            for(int i=1;i<=k && node!=null;i++){
                node=node.next;
            }
            if(node==null)
                break;
            ListNode prev=null,curr=pointer.next,next=null;
            for(int i=0;i<k;i++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode tail=pointer.next;
            tail.next=curr;
            pointer.next=prev;
            pointer=tail;
        }
        return dummyHead.next;
    }
}