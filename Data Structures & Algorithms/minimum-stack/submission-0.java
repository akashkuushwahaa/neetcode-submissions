class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> st = new Stack<Integer>();
    public void push(int x) {
        if(x <= min){          
            st.push(min);
            min=x;
        }
        st.push(x);
    }

    public void pop() {
        if(st.pop() == min) min=st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}