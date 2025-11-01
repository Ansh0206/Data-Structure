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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        ListNode dummy=new ListNode(-1);
        ListNode dTemp=dummy;

        ListNode temp=head;

        while(temp!=null){
            if(!set.contains(temp.val)){
                dTemp.next=temp;
                dTemp=dTemp.next;
            }
            temp=temp.next;
        }
        dTemp.next=null;
        return dummy.next;
        
    }
}