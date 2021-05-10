/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> st=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(!st.add(temp))
                return true;
            temp=temp.next;
        }
        return false;
    }
}