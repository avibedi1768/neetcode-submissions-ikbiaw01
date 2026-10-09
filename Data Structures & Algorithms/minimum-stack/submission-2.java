class MinStack {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int val) {
        st1.push(val);

        if (st2.isEmpty())
            st2.push(val);
        else
            st2.push(Math.min(val, st2.peek()));
    }

    public void pop() {
        st1.pop();
        st2.pop();
    }

    public int top() {
        return st1.peek();
    }

    public int getMin() {
        return st2.peek();
    }
}
