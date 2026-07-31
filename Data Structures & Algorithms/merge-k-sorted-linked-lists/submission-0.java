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
        List<Integer> sum=new ArrayList<>();
        for(ListNode k:lists){
            while(k!=null){
               sum.add(k.val);
               k=k.next;
            }
        }
        if(sum.size()==0)
        return null;
        Collections.sort(sum);
        ListNode head=new ListNode(sum.get(0));
        ListNode cur=head;
        for(int i=1;i<sum.size();i++){
         cur.next=new ListNode(sum.get(i));
         cur=cur.next;
        }
        return head;
    }
}