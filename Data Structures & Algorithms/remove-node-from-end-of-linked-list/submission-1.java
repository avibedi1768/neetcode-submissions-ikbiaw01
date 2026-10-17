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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = func(head);
        n = size - n + 1;

        int i = 1;

        ListNode ans = null, t = null;

        while (head != null) {
            if (i == n) {
                head = head.next;
                i++;
                continue;
            }

            ListNode nd = new ListNode(head.val);
            if (ans == null) {
                ans = nd;
                t = nd;
            } else {
                t.next = nd;
                t = t.next;
            }

            head = head.next;
            i++;
        }

        return ans;
    }

    int func(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}
