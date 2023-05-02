import java.util.Random;

/**
 * Created by pietrocenciarelli on 18/04/21.
 */
public class VeryUglyArrayStack implements Stack {

    /* It implements tha ADT of stacks of integers in a
    concurrent setting. The critical parts of push and pop
    are synchronized. When a popper finds an empty stack it
    goes to sleep, and it does so *outside* the synchronized
    block. It won't work because in between test and stack
    uptate there may be interferences! Sleeping inside (that
    is declaring push and pop synchronized) won't work either,
    because sleep() does not release locks.
    */

    private int[] stk;
    private int top = -1;

    VeryUglyArrayStack(int l) {
        stk = new int[l];
    }

    private void rest () throws InterruptedException {
        Thread.currentThread().sleep(100);
    }

    public boolean isEmpty () {
        return top == -1;
    }

    public boolean isFull () {
        return top == stk.length -1;
    }

    public synchronized void push (int v) throws InterruptedException {
        // pushes an int on top of the stack if there is
        // room for it, otherwise it *rests* and then tries again

        while (isFull()){
            rest();
        }
        // watch out here!!!
        
        // Random rand = new Random();

        // // Obtain a number between [0 - 49].
        // int n = rand.nextInt(500);
        // Thread.sleep(1000);

    
        System.out.println("pushing " + v);
        top = top + 1;
        stk[top] = v;
    }

    public int pop () throws InterruptedException {
        // pops and returns the top element if it
        // exists, otherwise it *rests* ant then tries again

        while (isEmpty())
            rest();

        // watch out here!!!

        synchronized (this) {
            int result = stk[top];
            System.out.println("popping " + result);
            top = top - 1;
            return result;
        }
    }
}
