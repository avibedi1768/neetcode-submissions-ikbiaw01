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
    public void reorderList(ListNode head) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ListNode t = head;

        while (t != null) {
            dq.add(t.val);
            t = t.next;
        }

        t = head;

        while (!dq.isEmpty()) {
            t.val = dq.removeFirst();

            t = t.next;
            if (dq.isEmpty())
                break;

            t.val = dq.removeLast();
            t = t.next;
        }

        // System.out.println(dq);
    }
}
