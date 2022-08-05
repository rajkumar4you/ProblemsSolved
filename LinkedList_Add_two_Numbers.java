/*You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.*/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1,head2=l2,prev=head2;
        int carry=0;
        while(l1!=null && l2!=null){
            int sum = (l1.val + l2.val+carry);
            l1.val = sum%10;
            l2.val=l1.val;
            carry = sum/10;
            prev=l2;
            l1=l1.next;
            l2=l2.next;
        }
        int flag1=0;
        while(carry!=0 && l1!=null){
            int sum = l1.val+carry;
            l1.val = sum%10;
            carry = sum/10;
            prev=l1;
            l1=l1.next;
            flag1=1;
        }
        if(l1!=null)
            flag1=1;
        while(carry!=0 && l2!=null){
            int sum = l2.val+carry;
            l2.val = sum%10;
            carry = sum/10;
            prev=l2;
            l2=l2.next;
        }
        if(carry!=0){
            ListNode node = new ListNode(carry,null);
            prev.next=node;
        }
        if(flag1==1)
            return head1;
        else
            return head2;
        
    }
}