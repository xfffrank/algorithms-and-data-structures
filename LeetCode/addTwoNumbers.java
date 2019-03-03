/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0, sum = 0;
        int x, y;
        while (l1 != null || l2 != null) {
            result.next = new ListNode(0);
            result = result.next;
            x = (l1 == null)? 0: l1.val;
            y = (l2 == null)? 0: l2.val;
            sum = x + y + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            int temp = sum % 10;
            result.val = temp;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            result.next = new ListNode(1);
        }
        return head.next;
    }
}