/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> old_to_new = new HashMap<>();
        Map<Node, Node> new_to_old = new HashMap<>();

        Node orig = head;
        Node ans = null, t = null;

        while (head != null) {
            Node nd = new Node(head.val);

            old_to_new.put(head, nd);
            new_to_old.put(nd, head);

            head = head.next;

            if (ans == null) {
                ans = nd;
                t = nd;
            } else {
                t.next = nd;
                t = t.next;
            }
        }

        // System.out.println(new_to_old);

        t = ans;

        while (t != null) {
            Node old = new_to_old.get(t);
            t.random = old_to_new.get(old.random);

            t = t.next;
        }

        return ans;
    }
}
