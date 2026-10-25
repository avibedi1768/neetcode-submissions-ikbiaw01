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
        ListNode ans = null, t = null;
        int size = size(head);

        while (head != null) {
            // System.out.println(head.val);

            if (k > size) {
                // cant reverse. return the remaining list
                t.next = head;
                break;
            }

            ListNode last = null, curr = null;
            for (int i = 1; i <= k; i++) {
                ListNode nd = new ListNode(head.val);

                nd.next = curr;
                curr = nd;

                if (last == null)
                    last = nd;

                head = head.next;
            }

            if (ans == null) {
                ans = curr;
                t = curr;
            } else {
                t.next = curr;
            }

            t = last;
            size -= k;
        }

        return ans;
    }

    int size(ListNode head) {
        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }
}
