/**
 * Created by pietrocenciarelli on 14/04/21.
 */
public class ArrayStack {

    /* implementation of the stacs abstract data type (using exceptions).
    Method pop() is synchronized, method push is not; hence two concurrent
    pushers may extract the same element.
    */

    private int[] stk;
    private int top = -1;

    ArrayStack(int l) {
        stk = new int[l];
    }

    public int capacity () {
        return stk.length;
    }

    public void push (int v) throws FullStackException {
        // inserts an element on top of the stack... if there is room for it!

        if (top == stk.length - 1) throw new FullStackException();
        top = top + 1;
        stk[top] = v;
    }

    // public synchronized int pop () throws EmptyStackException, InterruptedException {

    public int pop () throws EmptyStackException, InterruptedException {
        // extracts and returns the element on top of the stack... if the stack is not empty!
        // if unsynchronized the printing and the extraction by two threads may be interleaved

        System.out.println("It's me, " + Thread.currentThread().getName() + ", and I'm popping");

        // synchronized (this) { // alternative to synchronizin the whole method
        // synchronized (new Object()) { // won't work: two poppers (see AMess)...
            // ...synchronize on different objects
            if (top < 0) throw new EmptyStackException();
            top = top - 1;
            // Thread.currentThread().sleep(100);
            // this command, if in unsynchronized context, may
            // cause loss of elements (see AMess: 42 is lost)
            return stk[top + 1];
        //}
    }
}
