class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String p : tokens) {
            if ("+-*/".indexOf(p) != -1) {
                // arithmetic operation

                int a = st.pop();
                int b = st.pop();

                switch (p) {
                    case "+":
                        st.push(a + b);
                        break;

                    case "-":
                        st.push(b - a);
                        break;

                    case "*":
                        st.push(a * b);
                        break;

                    case "/":
                        st.push(b / a);
                        break;
                }
            } else {
                st.push(Integer.parseInt(p));
            }
        }

        return st.peek();
    }
}
