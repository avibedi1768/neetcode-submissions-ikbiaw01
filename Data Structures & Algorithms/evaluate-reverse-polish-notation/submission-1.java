class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String p : tokens) {
            if (p.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (p.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (p.equals("-")) {
                st.push(-1 * (st.pop() - st.pop()));
            } else if (p.equals("/")) {
                st.push((int) (1.0 / (st.pop() / (double) st.pop())));
            } else {
                st.push(Integer.parseInt(p));
            }
        }

        return st.pop();
    }
}
