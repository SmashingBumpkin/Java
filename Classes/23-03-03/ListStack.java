/**
 * Created by pietrocenciarelli on 03/03/21.
 */
public class ListStack {
    // list implementation of stacks

    public int len = 0;
    private IntList list = null;

    public boolean is_empty () {
        // returns true if the stack is empty, false otherwise

        return len == 0;
    }

    public void push (int v) {
        //insets v on top

        list = new IntList(v, list);
        len++;
    }

    public int pop () throws EmptyStackException {
        // pops

        if (len == 0) throw new EmptyStackException();

        int top = list.head;
        list = list.tail;
        len--;
        return top;
    }
}
