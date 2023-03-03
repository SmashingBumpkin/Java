/**
 * Created by pietrocenciarelli on 01/03/21.
 */
public class ArrayStack2 { // ...with exceptions

    private int[] stk;
    private int top = -1;

    ArrayStack2 (int l) {
        stk = new int[l];
    }

    public int lunghezza () {
        return stk.length;
    }

    public void push (int v) throws FullStackException {
        // inserts an int on top of the stack, if there is room for it!

        if (top == stk.length - 1)
            throw new FullStackException(v);

        stk[++top] = v;
    }

    public int pop () throws EmptyStackException {
        //extracts the top element, if it exists, and returns it

        if (top < 0)
            throw new EmptyStackException();

        return stk[top--];
    }
}
