/**
 * Created by pietrocenciarelli on 24/02/21.
 */

public class ArrayStack {

    private final static int SIZE = 10;
    private int[] stk;
    private int top = -1;

    ArrayStack() {
        stk = new int[SIZE];
    }

    ArrayStack(int l) {
        stk = new int[l];
    }

    public int lunghezza () {
        return stk.length;
    }

    public void push (int v) {
        // inserts an int on top of the stack
        stk[++top] = v;
    }

    public int pop () {
        //extracts the top element and returns it
        return stk[top--];
    }
}
