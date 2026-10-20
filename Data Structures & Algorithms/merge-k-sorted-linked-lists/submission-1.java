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
        List<Integer> al = new ArrayList<>();

        for (ListNode p : lists) {
            while (p != null) {
                al.add(p.val);
                p = p.next;
            }
        }

        Collections.sort(al);

        ListNode ans = null, t = null;

        for (int p : al) {
            ListNode nd = new ListNode(p);

            if (ans == null) {
                ans = nd;
                t = nd;
            } else {
                t.next = nd;
                t = t.next;
            }
        }

        return ans;
    }
}
